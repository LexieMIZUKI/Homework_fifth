package com.lexie.homeworkFifth;

import java.io.Serializable;

public class Song implements Serializable{
	//��Ա���ԣ�����id���������ƣ�������
	private String id;
	private String name;
	private String singer;
	
	//�޲ι��캯��
	public Song() {}
	
	//�������Դ��ι������
	public Song(String id, String name, String singer) {
		super();
		this.id = id;
		this.name = name;
		this.singer = singer;
	}
	//�������Ե�getter/setter����
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}
	//��дhashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((singer == null) ? 0 : singer.hashCode());
		return result;
	}
	//��дequals����
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (singer == null) {
			if (other.singer != null)
				return false;
		} else if (!singer.equals(other.singer))
			return false;
		return true;
	}
	//��дtoString����
	@Override
	public String toString() {
		return "������Ϣ ��idΪ��" + id + ", ��������Ϊ��" + name + ", �ݳ���Ϊ��" + singer;
	}
}
