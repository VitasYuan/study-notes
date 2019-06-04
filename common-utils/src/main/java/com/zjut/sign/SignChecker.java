package com.zjut.sign;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * @author yuanweipeng
 */
@SuppressWarnings(value = "unused")
public class SignChecker {

    private static final String DEFAULT_CHARACTER = "utf-8";

    /**
     * MD5效验码参数名称
     */
    private static final String SIGN_PARAM_NAME = "_wsign";

    /**
     * 时间戳参数名称
     */
    private static final String TIMESTAMP_PARAM_NAME = "_t";

    /**
     * 心跳时间戳参数名称
     */
    private static final String HEARTBEAT_TIMESTAMP_PARAM_NAME = "_timestamp";

    /**
     * 时间戳过期时间，以毫秒为单位（前后5分钟以内为不过期）
     */
    private static final long EXPIRED_TIME = 5 * 60 * 1000;

    private static final List<String> OBS_APPKEY_LIST;

    private static final List<String> ANDROID_APPKEY_LIST;

    private static final List<String> IOS_APPKEY_LIST;

    /**
     * 加密串分割符
     */
    private static final String SEP = "&";
    private static String obsKeyEntity = null;


    private static String androidCommonSignKey=null;
    private static String iosCommonSignKey=null;

    private static final String CONFIG_PATH = "/data/app/sign.properties";

    static {
        ANDROID_APPKEY_LIST = new ArrayList<>();
        IOS_APPKEY_LIST = new ArrayList<>();
        OBS_APPKEY_LIST = new ArrayList<>();
        try {
            File file = new File(CONFIG_PATH);
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                Properties po = new Properties();
                po.load(fileInputStream);
                androidCommonSignKey = po.getProperty("common.sign.android.key");
                iosCommonSignKey = po.getProperty("common.sign.ios.key");
            } else {
            }
        } catch (Exception e) {
        }

    }

    public static SignCheckResponse check(String uri, Map<String, String> params) {
        long nanoTime = System.nanoTime();
        try {
            // 校验时间戳
            String timestamp = params.getOrDefault(TIMESTAMP_PARAM_NAME, params.getOrDefault(HEARTBEAT_TIMESTAMP_PARAM_NAME, "0"));
            long currentTimestamp = System.currentTimeMillis();
            if (timestamp == null || timestamp.isEmpty() || (currentTimestamp - Long.parseLong(timestamp) > EXPIRED_TIME)) {
                return SignCheckResponse.REJECT;
            }

            // 如果没有appKey，则所有的都拒绝
            String appKey = params.getOrDefault("_appkey", "");
            if (appKey.isEmpty()) {
                return SignCheckResponse.REJECT;
            }

            String appVersion = params.getOrDefault("_appVersion", "");
            if (appVersion.isEmpty()) {
                return SignCheckResponse.REJECT;
            }

            // obs采用通用的加密方式，其他的采用特殊的加密方式
            SignCheckResponse checkResponse = SignCheckResponse.REJECT;
            if (OBS_APPKEY_LIST.contains(appKey)) {
                checkResponse = checkCommonSign(appKey, uri, params);
            } else if (ANDROID_APPKEY_LIST.contains(appKey)){
                try {
                    checkResponse = checkAndroidSpecialSign(appKey, uri, params);

                } catch (Exception e) {
                    checkResponse = SignCheckResponse.REJECT;
                }


            } else {
                //ios处理
                try {
                    int version = Integer.valueOf(appVersion.replace(".", ""));
                    checkResponse = checkCommonSign(appKey, uri, params);

                } catch (Exception e) {
                    checkResponse = SignCheckResponse.REJECT;
                }
            }

            if (checkResponse == SignCheckResponse.PASS) {
                return SignCheckResponse.PASS;
            } else if (checkResponse == SignCheckResponse.REJECT) {
                return SignCheckResponse.REJECT;
            } else {
                return SignCheckResponse.REVIEW;
            }
        } finally {
        }

    }

    public static SignCheckResponse check(HttpServletRequest request) {
        Map<String, String> paramMap = new TreeMap<>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            paramMap.put(paramName, request.getParameter(paramName));
        }
        return check(request.getRequestURI(), paramMap);
    }

    public static SignCheckResponse check(String uri, HttpServletRequest request) {
        Map<String, String> paramMap = new TreeMap<>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            paramMap.put(paramName, request.getParameter(paramName));
        }
        return check(uri, paramMap);
    }


    private static SignCheckResponse checkCommonSign(String appKey, String uri, Map<String, String> params) {
        try {

            // 如果没有初始化，则所有的都正常
            String key = getCommonSignKey(appKey);
            if (key == null) {
                return SignCheckResponse.PASS;
            }

            String sign = params.getOrDefault(SIGN_PARAM_NAME, "");

            String md5Result = MD5Digest.getMD5Digest(getSignString(params, key));
            if (!sign.isEmpty()) {
                boolean compareResult = sign.equals(md5Result);
                if (compareResult) {
                    return SignCheckResponse.PASS;
                }
            }
            return SignCheckResponse.REJECT;
        } catch (Exception e) {
            return SignCheckResponse.REVIEW;
        }
    }

    private static SignCheckResponse checkAndroidSpecialSign(String appKey, String uri, Map<String, String> params) {
        try {

            // 如果没有初始化，则所有的都正常
            if (androidCommonSignKey == null) {
                return SignCheckResponse.PASS;
            }

            String sign = params.getOrDefault(SIGN_PARAM_NAME, "");
            String paramString = getSignString(params, androidCommonSignKey);
            String calcuResult = MD5EnhancedDigest.digest(paramString);

            if (!sign.isEmpty()) {
                if (sign.equals(calcuResult)) {
                    return SignCheckResponse.PASS;
                }
            }
            return SignCheckResponse.REJECT;
        } catch (Exception e) {
            return SignCheckResponse.REVIEW;
        }
    }

    private static SignCheckResponse checkDevice(String appKey, String uri, Map<String, String> params) {
        String deviceCs = params.get("device_cs");
        if (deviceCs == null || deviceCs.isEmpty()) {
            return SignCheckResponse.REJECT;
        }
        try {
            if (ANDROID_APPKEY_LIST.contains(appKey)) {
                String deviceHardware = params.get("device_hardware");
                String deviceSerial = params.get("device_serial");
                String deviceId = params.get("device_id");
                String deviceMac = params.get("device_mac");
                String deviceBoard = params.get("device_board");

                StringBuilder sb = new StringBuilder();
                sb.append("ba193bcabd474fb9a6662a8bb9bfaee1");
                if (deviceHardware != null && !deviceHardware.isEmpty()) {
                    sb.append("^*^device_hardwareU_U").append(deviceHardware);
                }
                if (deviceSerial != null && !deviceSerial.isEmpty()) {
                    sb.append("^*^device_serialU_U").append(deviceSerial);
                }
                if (deviceId != null && !deviceId.isEmpty()) {
                    sb.append("^*^device_idU_U").append(deviceId);
                }
                if (deviceMac != null && !deviceMac.isEmpty()) {
                    sb.append("^*^device_macU_U").append(deviceMac);
                }
                if (deviceBoard != null && !deviceBoard.isEmpty()) {
                    sb.append("^*^device_boardU_U").append(deviceBoard);
                }
                String sign = MD5Digest.getMD5Digest(sb.toString());
                if (sign.equals(deviceCs)) {
                    return SignCheckResponse.PASS;
                } else {
                    return SignCheckResponse.REJECT;
                }
            } else {
                String deviceModel = params.get("device_model");
                String deviceRelease = params.get("device_release");
                String deviceUser = params.get("device_user");
                String idfa = params.get("_idfa");
                String identifier = params.get("_identifier");

                StringBuilder sb = new StringBuilder();
                sb.append("ba193bcabd474fbsdfsadf2ea8bb9bfaee1");
                if (deviceModel != null && !deviceModel.isEmpty()) {

                    sb.append("*&*device_model@_@").append(deviceModel);
                }
                if (deviceRelease != null && !deviceRelease.isEmpty()) {

                    sb.append("*&*device_release@_@").append(deviceRelease);
                }
                if (deviceUser != null && !deviceUser.isEmpty()) {

                    sb.append("*&*device_user@_@").append(deviceUser);
                }
                if (idfa != null && !idfa.isEmpty()) {

                    sb.append("*&*_idfa@_@").append(idfa);
                }
                if (identifier != null && !identifier.isEmpty()) {

                    sb.append("*&*_identifier@_@").append(identifier);
                }
                String sign = MD5Digest.getMD5Digest(sb.toString());
                if (sign.equals(deviceCs)) {
                    return SignCheckResponse.PASS;
                } else {
                    return SignCheckResponse.REJECT;
                }
            }
        } catch (Exception e) {
            return SignCheckResponse.REVIEW;
        }
    }

    private static String getCommonSignKey(String appKey) {

        if (ANDROID_APPKEY_LIST.contains(appKey)) {
            return androidCommonSignKey;
        } else if (IOS_APPKEY_LIST.contains(appKey)) {
            return iosCommonSignKey;
        } else if (OBS_APPKEY_LIST.contains(appKey)) {
            return obsKeyEntity;
        }
        return null;
    }

    private static String getSignString(Map<String, String> params, String md5Key) {
        Map<String, String> sortedMap;
        if (params instanceof TreeMap) {
            sortedMap = params;
        } else {
            sortedMap = new TreeMap<>(params);
        }

        StringBuilder buffer = new StringBuilder();
        buffer.append(md5Key);
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            if (SIGN_PARAM_NAME.equals(entry.getKey())) {
                continue;
            }
            buffer.append(SEP);
            buffer.append(entry.getKey());
            buffer.append("=");
            buffer.append(entry.getValue() == null ? "" : String.valueOf(entry.getValue()));
        }
        return buffer.toString();
    }
}
