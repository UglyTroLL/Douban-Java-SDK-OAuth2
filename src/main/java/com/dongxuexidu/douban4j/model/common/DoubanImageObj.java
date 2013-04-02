package com.dongxuexidu.douban4j.model.common;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.google.api.client.util.Key;

/**
 * 
 * @author Sean Guo <seanguo85@qq.com>
 *
 */
public class DoubanImageObj implements IDoubanObject {

	@Override
	public String getObjName() {
		return "image";
	}

	@Key("small")
	private String small;

	@Key("medium")
	private String media;

	@Key("large")
	private String large;

	public String getSmall() {
		return small;
	}

	public void setSmall(String small) {
		this.small = small;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getLarge() {
		return large;
	}

	public void setLarge(String large) {
		this.large = large;
	}

	@Override
	public String toString() {
		return "DoubanImageObj [small=" + small + ", media=" + media
				+ ", large=" + large + "]";
	}
}
