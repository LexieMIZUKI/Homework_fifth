package com.lexie.homeworkFifth;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PlayList {
	//��Ա���ԣ������б����ƣ������б��и����ļ���
	private String playListName;
	private List<Song> musicList;
	Iterator<Song> it;
	Song song;
	
	//�޲ι��캯��
	public PlayList() {}
	//�������Դ��ι��캯��
	public PlayList(String playListName) {
		super();
		this.playListName = playListName;
	}
	//�������Դ��ι��캯��
	public PlayList(String playListName, List<Song> musicList) {
		super();
		this.playListName = playListName;
		this.musicList = musicList;
	}
	//��������getter/setter����
	public String getPlayListName() {
		return playListName;
	}
	public void setPlayListName(String playListName) {
		this.playListName = playListName;
	}
	public List<Song> getMusicList() {
		return musicList;
	}
	public void setMusicList(List<Song> musicList) {
		this.musicList = musicList;
	}
	
	@Override
	public String toString() {
		return getPlayListName();
	}
	
	//��������ӵ������б�ķ���
	public void addToPlayList(Song song) {
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		musicList = new ArrayList<Song>();
		
		System.out.println("������Ӽ��׸�����"+this.getPlayListName()+"�����б��У�");
		int j = scan.nextInt();
		for(int i = 0;i < j;i++) {
			song = new Song();
			System.out.println("����ӵ�"+(i+1)+"����id��");
			song.setId(scan1.nextLine());
			System.out.println("����Ӹ������ƣ�");
			song.setName(scan1.nextLine());
			System.out.println("����Ӹ�������");
			song.setSinger(scan1.nextLine());
			musicList.add(song);
		}
		System.out.println("��ӳɹ���");
		this.displayAllSong();
	}
	
	//��ʾ�����б������и���
	public void displayAllSong() {
		if(musicList.isEmpty())
			System.out.println("��ǰ�б�Ϊ�գ��뷵�ز˵��������ӣ�");
		else {
			it = musicList.iterator();
			System.out.println(getPlayListName()+"�еĸ�����Ϣ���£�");
			while(it.hasNext()) {
			System.out.println(it.next());
			}			
		}
	}
	
	//ͨ��id��ѯ����
	public Song searchSongById(String id) {
		Scanner scan = new Scanner(System.in);		
		boolean flag = true;
		while(flag) {
			it = musicList.iterator();
			while(it.hasNext()) {
				song = it.next();
			if(id.equals(song.getId())) {
				flag = false; 
				break;
			}
			}
			if(flag) {
				System.out.println("û�ҵ������������룡"); 
				System.out.println("��������Ҫ��ѯ�ĸ�����id��");
				id = scan.nextLine();
			}
		}
		return song;
	}
	
	//ͨ�����Ʋ�ѯ����
	public Song searchSongByName(String n) {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			it = musicList.iterator();
			while(it.hasNext()) {
				song = it.next();
				if(n.equals(song.getName())) {
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println("û�ҵ������������룡"); 
				System.out.println("��������Ҫ��ѯ�ĸ��������ƣ�");
				n = scan.nextLine();
			}
		}
		return song;
	}
	
	//�޸ĸ���
	public void updateSong(String id,Song song) {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			it = musicList.iterator();
			while(it.hasNext()) {
				song = it.next();
				if(id.equals(song.getId())) {
					System.out.println("�������޸ĺ�ĸ�������");
					song.setName(scan.nextLine());
					System.out.println("�������޸ĺ�ĸ�������");
					song.setSinger(scan.nextLine());
					System.out.println("�޸ĳɹ���");
					this.displayAllSong();
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println("û�ҵ������������룡"); 
				System.out.println("��������Ҫ��ѯ�ĸ�����id��");
				id = scan.nextLine();
			}
		}
	}
	
	//�Ӳ����б�ɾ������
	public void deleteSong(String id) {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			it = musicList.iterator();
			while(it.hasNext()) {
				song = it.next();
				if(id.equals(song.getId())) {
					musicList.remove(song);
					System.out.println("ɾ���ɹ���");
					this.displayAllSong();
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println("û�ҵ������������룡"); 
				System.out.println("��������Ҫɾ���ĸ�����id��");
				id = scan.nextLine();
			}
		}
	}
	
	//�����赥
	public void exportPlayList() {
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\LexieLUV\\Desktop\\programming\\file\\song.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			FileInputStream fis = new FileInputStream("C:\\Users\\LexieLUV\\Desktop\\programming\\file\\song.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			it = musicList.iterator();
			while(it.hasNext()) {
				song = it.next();
				oos.writeObject(song);
			}
			oos.flush();
			fos.close();
			fis.close();
			ois.close();
			oos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
