<?php
	if($_SERVER['REQUEST_METHOD']=='POST'){
		//Mendapatkan Nilai Variable
		$nim = $_POST['Nim'];
		$nama = $_POST['nama'];
		$jurusan = $_POST['jurusan'];
		$alamat= $_POST['alamat'];
		$tmplahir = $_POST['tmplahir'];
		$tgllahir = $_POST['tgllahir'];
		$agama	=$_POST['agama'];

		//Pembuatan Syntax SQL
		$sql = "INSERT INTO tb_mahasiswa (nim,nama,jurusan,alamat,tmplahir,tgllahir,agama) VALUES ('$nim','$nama','$jurusan','$alamat','$tmplahir','$tgllahir','$agama')";

		//Import File Koneksi database
		require_once('koneksi.php');
        
		//Eksekusi Query database
		if(mysqli_query($sql)){
			echo 'Berhasil Menambahkan Data Mahasiswa';
		}else{
			echo 'Gagal Menambahkan Data Mahasiswa';
		}

	}
?>
