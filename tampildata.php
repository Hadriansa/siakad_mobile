<?php 
if($_SERVER['REQUEST_METHOD']=='GET'){
$id=$_GET['id'];//15.50.001
require_once('koneksi.php');
$sql="select * from tb_mahasiswa where nim='$id'";//15.50.001
$r=mysqli_query($koneksi,$sql);
$result=array();
$row=mysqli_fetch_array($r);
array_push($result,array("nim"=>$row['nim'],
	"nama"=>$row['nama'],
	"alamat"=>$row['alamat'],
	"jurusan"=>$row['jurusan'],
	"tmplahir"=>$row['tmplahir'],
	"tgllahir"=>$row['tgllahir'],
	"agama"=>$row['agama']));
echo json_encode(array('mahasiswa'=>$result));

}
?>