package com.insertDummyBlob;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//import com.actImg.model.ActImg;
//import com.actImg.model.ActImgJDBCDAO;
//import com.activity.model.Activity;
//import com.activity.model.ActivityJDBCDAO;
//import com.ad.model.Ad;
//import com.ad.model.AdJDBCDAO;
//import com.album.model.Album;
//import com.album.model.AlbumJDBCDAO;
//import com.albumimg.model.AlbumImg;
//import com.albumimg.model.AlbumImgJDBCDAO;
import com.dateitem.model.DateItemJDBCDAO;
import com.dateitem.model.DateItemVO;
//import com.dateitemapp.model.DateItemApp;
//import com.dateitemapp.model.DateItemAppJDBC;
//import com.dateitmerep.model.DateItemRep;
//import com.dateitmerep.model.DateItemRepJDBC;
//import com.diary.model.Diary;
//import com.diary.model.DiaryJDBCDAO;
//import com.member.model.Member;
//import com.member.model.MemberJDBCDAO;
//import com.pet.model.Pet;
//import com.pet.model.PetJDBCDAO;
//import com.product.model.Product;
//import com.product.model.ProductJDBCDAO;
//import com.restImg.model.RestImg;
//import com.restImg.model.RestImgJDBCDAO;
//import com.slide.model.Slide;
//import com.slide.model.SlideJDBCDAO;

public class InsertDummyBlob2 {

	public static void main(String[] args) {

   
    

    
    // �o�_���ʷӤ��ק�
//    int j = 8001;
//    for (File file : new File("WebContent/DummyImg/activityInitImg").listFiles()) { 
//    	ActivityJDBCDAO activityDAO=new ActivityJDBCDAO();
//    	Activity activity=activityDAO.findByPK(j++);
//        try {
//			byte[] b = getPictureByteArray(file);
//			activity.setActInitImg(b);
//			activityDAO.update(activity);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}    
//    }
//    System.out.println("=============�o�_���ʷӤ��s�W����================");
//
//
// // ���ʷӤ��ק�
//    int k = 8001;
//    for (File file : new File("WebContent/DummyImg/actImg").listFiles()) { 
//    	ActImgJDBCDAO actImgJDBCDAO=new ActImgJDBCDAO();
//    	ActImg actImg=actImgJDBCDAO.findByPK(k++);
//        try {
//			byte[] b = getPictureByteArray(file);
//			actImg.setActImg(b);
//			actImgJDBCDAO.update(actImg);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}    
//    }
//    System.out.println("=============���ʷӤ��s�W����================");
//    
//    
//	// �s�i�Ϥ��ק�
//	int aa = 1;
//	for (File file : new File("WebContent/DummyImg/ad").listFiles()) {
//		AdJDBCDAO dao = new AdJDBCDAO();
//		Ad ad = dao.findByPrimaryKey(aa++);
//		try {
//			byte[] b = getPictureByteArray(file);
//			ad.setAdImg(b);
//			dao.update(ad);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	System.out.println("=============�s�i�Ϥ��ק粒�F================");
//
//	// �ۿO���ק�
//	int s = 1;
//	for (File file : new File("WebContent/DummyImg/slide").listFiles()) {
//		SlideJDBCDAO dao = new SlideJDBCDAO();
//		Slide slide = dao.findByPrimaryKey(s++);
//		try {
//			byte[] b = getPictureByteArray(file);
//			slide.setSlideImg(b);
//			dao.update(slide);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	System.out.println("=============�ۿO���ק粒�F================");
    
	// ���|�ӫ~�Ϥ��ק�
	int di=4001;
    for (File file : new File("WebContent/DummyImg/dateitem").listFiles()) { 
    	DateItemJDBCDAO dao=new DateItemJDBCDAO();
    	DateItemVO dateItem=dao.findByPk(di++);
        try {
			byte[] b = getPictureByteArray(file);
			dateItem.setDateItemImg(b);
			dao.update(dateItem);
		} catch (IOException e) {
			e.printStackTrace();
		}    
    }
//    System.out.println("=============���|�ӫ~�Ϥ��ק粒�F================");   

//	// ��x�Ϥ��ק�
//	int dia=10001;
//    for (File file : new File("WebContent/DummyImg/diary").listFiles()) { 
//    	DiaryJDBCDAO dao=new DiaryJDBCDAO();
//    	Diary diary=dao.findByPrimaryKey(dia++);
//        try {
//			byte[] b = getPictureByteArray(file);
//			diary.setDiaimg(b);
//			dao.update(diary);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}    
//    }
//    System.out.println("=============��x�Ϥ��ק粒�F================");   
//    
//    
//
//    
//	// �ӶD�Ϥ��ק�
//	int app=60001;
//    for (File file : new File("WebContent/DummyImg/DateItemApp").listFiles()) { 
//    	DateItemAppJDBC dao=new DateItemAppJDBC();
//    	DateItemApp dateItemApp=dao.findByPrimaryKey(app++);
//        try {
//			byte[] b = getPictureByteArray(file);
//			dateItemApp.setAppImg(b);
//			dao.update(dateItemApp);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}    
//    }
//    System.out.println("=============�ӶD�Ϥ��ק�================");   
//    
//    
//    
//    
//    
//    
//    
//    
//    
	}

	
	
	
	
	public static byte[] getPictureByteArray(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[8192];
		int i;
		while ((i = fis.read(buffer)) != -1) {
			baos.write(buffer, 0, i);
		}
		baos.close();
		fis.close();

		return baos.toByteArray();
	}
	
}
