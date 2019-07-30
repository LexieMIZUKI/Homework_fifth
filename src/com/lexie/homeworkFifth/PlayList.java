package com.lexie.homeworkFifth;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PlayList {
	//成员属性：播放列表名称，播放列表中歌曲的集合
	private String playListName;
	private List<Song> musicList;
	Iterator<Song> it;
	Song song;
	
	//无参构造函数
	public PlayList() {}
	//部分属性带参构造函数
	public PlayList(String playListName) {
		super();
		this.playListName = playListName;
	}
	//所有属性带参构造函数
	public PlayList(String playListName, List<Song> musicList) {
		super();
		this.playListName = playListName;
		this.musicList = musicList;
	}
	//所有属性getter/setter方法
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
	
	//将歌曲添加到播放列表的方法
	public void addToPlayList(Song song) {
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		musicList = new ArrayList<Song>();
		
		System.out.println("您想添加几首歌曲到"+this.getPlayListName()+"播放列表中：");
		int j = scan.nextInt();
		for(int i = 0;i < j;i++) {
			song = new Song();
			System.out.println("请添加第"+(i+1)+"歌曲id：");
			song.setId(scan1.nextLine());
			System.out.println("请添加歌曲名称：");
			song.setName(scan1.nextLine());
			System.out.println("请添加歌手名：");
			song.setSinger(scan1.nextLine());
			musicList.add(song);
		}
		System.out.println("添加成功！");
		this.displayAllSong();
	}
	
	//显示播放列表中所有歌曲
	public void displayAllSong() {
		if(musicList.isEmpty())
			System.out.println("当前列表为空！请返回菜单后进行添加！");
		else {
			it = musicList.iterator();
			System.out.println(getPlayListName()+"中的歌曲信息如下：");
			while(it.hasNext()) {
			System.out.println(it.next());
			}			
		}
	}
	
	//通过id查询歌曲
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
				System.out.println("没找到！请重新输入！"); 
				System.out.println("请输入您要查询的歌曲的id：");
				id = scan.nextLine();
			}
		}
		return song;
	}
	
	//通过名称查询歌曲
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
				System.out.println("没找到！请重新输入！"); 
				System.out.println("请输入您要查询的歌曲的名称：");
				n = scan.nextLine();
			}
		}
		return song;
	}
	
	//修改歌曲
	public void updateSong(String id,Song song) {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			it = musicList.iterator();
			while(it.hasNext()) {
				song = it.next();
				if(id.equals(song.getId())) {
					System.out.println("请输入修改后的歌曲名：");
					song.setName(scan.nextLine());
					System.out.println("请输入修改后的歌手名：");
					song.setSinger(scan.nextLine());
					System.out.println("修改成功！");
					this.displayAllSong();
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println("没找到！请重新输入！"); 
				System.out.println("请输入您要查询的歌曲的id：");
				id = scan.nextLine();
			}
		}
	}
	
	//从播放列表删除歌曲
	public void deleteSong(String id) {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			it = musicList.iterator();
			while(it.hasNext()) {
				song = it.next();
				if(id.equals(song.getId())) {
					musicList.remove(song);
					System.out.println("删除成功！");
					this.displayAllSong();
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println("没找到！请重新输入！"); 
				System.out.println("请输入您要删除的歌曲的id：");
				id = scan.nextLine();
			}
		}
	}
	
	//导出歌单
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
