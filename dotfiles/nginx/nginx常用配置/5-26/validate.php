<?php
      $conn = mysql_connect("localhost",'root','') or die("数据库连接失败！");
      mysql_select_db("info",$conn) or die("您要选择的数据库不存在");
      $name=$_POST['username'];
      $pwd=$_POST['password'];
      $sql="select * from users where username='$name' and password='$pwd'";
      echo $sql."<br /><br />";
      $query=mysql_query($sql);
      $arr=mysql_fetch_array($query);
      if($arr){
          echo "login success!\n";
          echo $arr[1];
          echo $arr[3]."<br /><br />";
      }else{
          echo "login failed!";
      }
    
      #if(is_array($arr)){
      #       header("Location:manager.php");
      #}else{
      #       echo "您的用户名或密码输入有误，<a href="Login.php">请重新登录！</a>";
      #}
?>
