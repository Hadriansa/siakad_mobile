<?php  
 include 'koneksi.php';
 mysqli_set_charset($koneksi, 'utf8');
 $hasil         = mysqli_query($koneksi,"SELECT * FROM tb_mahasiswa") or die(mysqli_error());
 $json_response = array();
if(mysqli_num_rows($hasil)> 0){
while ($row = mysqli_fetch_array($hasil)) {
$json_response[] = $row;
}

echo json_encode(array('mahasiswa' => $json_response));} 
?>