package com.digimaster.mybackend;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class UserDetailResponseModel extends UserResponseModel{
	@SerializedName("name")
	private String name;
	@SerializedName("company")
	private String company;
	@SerializedName("blog")
	private String blog;
	@SerializedName("location")
	private String location;
	@SerializedName("email")
	private Object email;
	@SerializedName("hireable")
	private Object hireable;
	@SerializedName("bio")
	private Object bio;
	@SerializedName("twitter_username")
	private String twitterUsername;
	@SerializedName("public_repos")
	private Integer publicRepos;
	@SerializedName("public_gists")
	private Integer publicGists;
	@SerializedName("followers")
	private Integer followers;
	@SerializedName("following")
	private Integer following;
	@SerializedName("created_at")
	private String createdAt;
	@SerializedName("updated_at")
	private String updatedAt;
}
