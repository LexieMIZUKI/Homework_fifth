package com.lexie.homeworkFifth;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.List;

public class PlayListCollection {
	//存放播放列表的集合
	Song song;
	private Map<String,PlayList> playListMap = new HashMap<String,PlayList>();
	Iterator<String> it;
	PlayList playList = new PlayList();
	Set<String> playListSet;
	
	//无参构造函数
	public PlayListCollection() {}
	//带参构造函数
	public PlayListCollection(Map<String,PlayList> playListMap) {
		super();
		this.playListMap = playListMap;
	}
	//getter/setter方法
	public Map<String,PlayList> getPlayListMap() {
		return playListMap;
	}
	public void setPlayListMap(Map<String,PlayList> playListMap) {
		this.playListMap = playListMap;
	}
	
	
	//删除播放列表
	public void deletePlayList(PlayList playList) {
			playListMap.remove(playList.getPlayListName());
			System.out.println("该播放列表删除成功！");
			this.displayPlayListName();
	}
	//添加播放列表
		public void addPlayList(PlayList playList) {
			playListMap.put(playList.getPlayListName(), playList);
			System.out.println("播放列表添加成功！");
			this.displayPlayListName();
		}
	
	//通过名字查询
	public PlayList searchPlayListByName(String playListName) {
		Scanner scan = new Scanner(System.in);
		playListSet = playListMap.keySet();
		boolean flag = true;
		while(flag) {
		it = playListSet.iterator();
		while(it.hasNext()) {
			if(playListName.equals(it.next())) {
				playList = playListMap.get(playListName);
				System.out.println("存在该播放列表！名称是：");
				flag = false;
				break;
			}
			}
			if(flag) {
				System.out.println("没找到该名字！请重新输入！");
				System.out.println("请输入您要查询的播放列表的名字：");
				playListName = scan.nextLine();
			}
		}
		return playList;
	}
	
	//显示所有播放列表名称
	public void displayPlayListName() {
		if(playListMap.isEmpty())
			System.out.println("播放器内容为空！请返回菜单后进行添加！");
		else {
			it = playListMap.keySet().iterator();
			System.out.println("所有播放列表的名称如下：");
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		}
	}
}
