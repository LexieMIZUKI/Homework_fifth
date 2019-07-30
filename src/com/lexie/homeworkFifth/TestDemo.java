package com.lexie.homeworkFifth;

import java.util.Scanner;

public class TestDemo {
	Song song = new Song();
	Scanner scan = new Scanner(System.in);
	Scanner scan1 = new Scanner(System.in);
	Scanner scan2 = new Scanner(System.in);
	PlayList pl = new PlayList();
	PlayList pll = new PlayList();
	PlayListCollection plc = new PlayListCollection();
	
	//���Ը�����
	public void testSong() {
		Song song = new Song("s001","Mean","Taylor");
		System.out.println(song);
	}
	
	//���Բ����б���
	public void testPlayList() {
		
		System.out.println("��ѡ����ӵ��ĸ������б�");
		pl.addToPlayList(song);
		pl.displayAllSong();
		System.out.println("��������Ҫ��ѯ�ĸ�����id��");
		System.out.println(pl.searchSongById(scan.nextLine()));
		System.out.println("��������Ҫ��ѯ�ĸ��������ƣ�");
		System.out.println(pl.searchSongByName(scan.nextLine()));
		System.out.println("��������Ҫ�޸ĵĸ�����id��");
		pl.updateSong(scan.nextLine(), song);
		System.out.println("��������Ҫɾ���ĸ�����id��");
		pl.deleteSong(scan.nextLine());
		pl.exportPlayList();
	}
	
	//���Բ�������
	public void testPlayListCollection() {
		plc.addPlayList(pl);
		plc.deletePlayList(pl);
		System.out.println("��������Ҫ��ѯ�Ĳ����б�����֣�");
		System.out.println(plc.searchPlayListByName(scan.nextLine()));
		plc.displayPlayListName();
	}
	
	//���˵�
	public void mainMenu() {
		System.out.println("***************************");
		System.out.println("          **���˵�**          ");
		System.out.println("        1--�����б����                                ");
		System.out.println("        2--����������                                ");
		System.out.println("        0--�˳�                               ");
		System.out.println("***************************");
		System.out.println("�������Ӧ���ֽ��в�����");
	}
	
	//�����б����˵�
	public void playListMenu() {
		boolean flag = true;
		while(flag) {
		System.out.println("***************************");
		System.out.println("       **�����б����**        ");
		System.out.println("    1--��������ӵ��������б�                  ");
		System.out.println("    2--��������ӵ���ͨ�����б�              ");
		System.out.println("    3--ͨ������id��ѯ�����б��еĸ���  ");
		System.out.println("    4--ͨ���������Ʋ�ѯ�����б��еĸ���  ");
		System.out.println("    5--�޸Ĳ����б��еĸ���  ");
		System.out.println("    6--ɾ�������б��еĸ���  ");
		System.out.println("    7--��ʾ�����б��е����и���  ");
		System.out.println("    8--�����赥  ");
		System.out.println("    9--������һ���˵�  ");
		System.out.println("***************************");
		System.out.println("�������Ӧ���ֶԲ����б���й���");
		int n2 = scan.nextInt();
		switch(n2) {
		case 1: 
			pl.setPlayListName("�������б�");
			pl.addToPlayList(song);
			break;
		case 2:
			System.out.println("��Ϊ��ͨ�����б�ȡ�����֣�");
			pll.setPlayListName(scan2.nextLine());
			pll.addToPlayList(song);
			break;
		case 3:
			System.out.println("�������Ҫ��ѯ�Ĳ����б�����ƣ�");
			String s1 = scan1.nextLine();
			if(s1.equals(pl.getPlayListName())) {
				System.out.println("��������Ҫ��ѯ�ĸ�����id��");
				System.out.println(pl.searchSongById(scan2.nextLine()));
			}else if(s1.equals(pll.getPlayListName())) {
				System.out.println("��������Ҫ��ѯ�ĸ�����id��");
				System.out.println(pll.searchSongById(scan2.nextLine()));
			}
			break;
		case 4:
			System.out.println("�������Ҫ��ѯ�Ĳ����б�����ƣ�");
			String s2 = scan1.nextLine();
			if(s2.equals(pl.getPlayListName())) {
				System.out.println("��������Ҫ��ѯ�ĸ��������ƣ�");
				System.out.println(pl.searchSongByName(scan2.nextLine()));
			}else if(s2.equals(pll.getPlayListName())) {
				System.out.println("��������Ҫ��ѯ�ĸ��������ƣ�");
				System.out.println(pll.searchSongByName(scan2.nextLine()));
			}
			break;
		case 5:
			System.out.println("�������Ҫ�޸ĵĲ����б�����ƣ�");
			String s3 = scan1.nextLine();
			if(s3.equals(pl.getPlayListName())) {
				System.out.println("��������Ҫ�޸ĵĸ�����id��");
				pl.updateSong(scan2.nextLine(), song);
			}else if(s3.equals(pll.getPlayListName())) {
				System.out.println("��������Ҫ�޸ĵĸ�����id��");
				pl.updateSong(scan2.nextLine(), song);
			}
			break;
		case 6:
			System.out.println("�������Ҫɾ���Ĳ����б�����ƣ�");
			String s4 = scan1.nextLine();
			if(s4.equals(pl.getPlayListName())) {
				System.out.println("��������Ҫɾ���ĸ�����id��");
				pl.deleteSong(scan2.nextLine());
			}else if(s4.equals(pll.getPlayListName())) {
				System.out.println("��������Ҫɾ���ĸ�����id��");
				pll.deleteSong(scan2.nextLine());
			}
			break;
		case 7:
			pl.displayAllSong();
			pll.displayAllSong();
			break;
		case 8:
			pl.exportPlayList();
			pll.exportPlayList();
			System.out.println("�����ɹ���");
			break;
		case 9:
			flag = false;
			this.test();
			break;
		default:
			System.out.println("�����������������!");
			break;
		}
		}
	}
	
	//�������˵�
	public void playerMenu() {
		boolean flag = true;
		while(flag) {
		System.out.println("***************************");
		System.out.println("       **����������**        ");
		System.out.println("    1--�򲥷�����Ӳ����б�                  ");
		System.out.println("    2--�Ӳ�����ɾ�������б�              ");
		System.out.println("    3--ͨ�����ֲ�ѯ�����б���Ϣ  ");
		System.out.println("    4--��ʾ���в����б�����  ");
		System.out.println("    9--������һ���˵�  ");
		System.out.println("***************************");
		System.out.println("�������Ӧ���ֶԲ��������й���");
		int n3 = scan.nextInt();
		switch (n3) {
		case 1:
			System.out.println("�������Ҫ��ӵĲ����б�����ƣ�");
			String s0 = scan1.nextLine();
			if(s0.equals(pl.getPlayListName()))
				plc.addPlayList(pl);
			else if(s0.equals(pll.getPlayListName()))
				plc.addPlayList(pll);
			break;
		case 2:
			boolean flag2 = true;
			while(flag2) {
				System.out.println("�������Ҫɾ���Ĳ����б�����ƣ�");
				String s5 = scan1.nextLine();
				if(s5.equals(pl.getPlayListName())) {
					flag2 = false;
					plc.deletePlayList(pl);
				}
				else if(s5.equals(pll.getPlayListName())) {
					flag2 = false;
					plc.deletePlayList(pll);
				}
				else
					System.out.println("û�ҵ������֣����������룡");
			}
			break;
		case 3:
			System.out.println("��������Ҫ��ѯ�Ĳ����б�����֣�");
			System.out.println(plc.searchPlayListByName(scan2.nextLine()));
			break;
		case 4:
			plc.displayPlayListName();
			break;
		case 9:
			flag = false;
			this.test();
			break;
		default:
			System.out.println("�����������������!");
			break;
		}
		}
	}
	
	//������ʵ��
	public void test() {
		boolean flag = true;
		while(flag) {
			this.mainMenu();
			int n1 = scan.nextInt();
			switch(n1) {
			case 1:
				this.playListMenu();
				flag = false;
				break;
			case 2:
				this.playerMenu();
				flag = false;
				break;
			case 0:
				System.out.println("�ټ���");
				flag = false;
				break;
				default:
					System.out.println("�����������������!");
					break;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestDemo td = new TestDemo();
//		//���Ը�����
//		td.testSong();
//		//���Բ����б���
//		td.testPlayList();
//		//���Բ�������
//		td.testPlayListCollection();
		
		//��ʽ��ʼ����
		td.test();
	}
}
