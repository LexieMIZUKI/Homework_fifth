package com.lexie.homeworkFifth;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.List;

public class PlayListCollection {
	//��Ų����б�ļ���
	Song song;
	private Map<String,PlayList> playListMap = new HashMap<String,PlayList>();
	Iterator<String> it;
	PlayList playList = new PlayList();
	Set<String> playListSet;
	
	//�޲ι��캯��
	public PlayListCollection() {}
	//���ι��캯��
	public PlayListCollection(Map<String,PlayList> playListMap) {
		super();
		this.playListMap = playListMap;
	}
	//getter/setter����
	public Map<String,PlayList> getPlayListMap() {
		return playListMap;
	}
	public void setPlayListMap(Map<String,PlayList> playListMap) {
		this.playListMap = playListMap;
	}
	
	
	//ɾ�������б�
	public void deletePlayList(PlayList playList) {
			playListMap.remove(playList.getPlayListName());
			System.out.println("�ò����б�ɾ���ɹ���");
			this.displayPlayListName();
	}
	//��Ӳ����б�
		public void addPlayList(PlayList playList) {
			playListMap.put(playList.getPlayListName(), playList);
			System.out.println("�����б���ӳɹ���");
			this.displayPlayListName();
		}
	
	//ͨ�����ֲ�ѯ
	public PlayList searchPlayListByName(String playListName) {
		Scanner scan = new Scanner(System.in);
		playListSet = playListMap.keySet();
		boolean flag = true;
		while(flag) {
		it = playListSet.iterator();
		while(it.hasNext()) {
			if(playListName.equals(it.next())) {
				playList = playListMap.get(playListName);
				System.out.println("���ڸò����б������ǣ�");
				flag = false;
				break;
			}
			}
			if(flag) {
				System.out.println("û�ҵ������֣����������룡");
				System.out.println("��������Ҫ��ѯ�Ĳ����б�����֣�");
				playListName = scan.nextLine();
			}
		}
		return playList;
	}
	
	//��ʾ���в����б�����
	public void displayPlayListName() {
		if(playListMap.isEmpty())
			System.out.println("����������Ϊ�գ��뷵�ز˵��������ӣ�");
		else {
			it = playListMap.keySet().iterator();
			System.out.println("���в����б���������£�");
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		}
	}
}
