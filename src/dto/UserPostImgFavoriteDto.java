package com.mySNS.dto;

public class UserPostImgFavoriteDto {
    private UserDto userdto;
    private PostDto postdto;
    private ImgDto imgdto;
    private FavoriteDto favoritedto;
    public UserDto getUserdto() {
        return userdto;
    }
    public void setUserdto(UserDto userdto) {
        this.userdto = userdto;
    }
    public PostDto getPostdto() {
        return postdto;
    }
    public void setPostdto(PostDto postdto) {
        this.postdto = postdto;
    }
    public ImgDto getImgdto() {
        return imgdto;
    }
    public void setImgdto(ImgDto imgdto) {
        this.imgdto = imgdto;
    }
    public FavoriteDto getFavoritedto() {
        return favoritedto;
    }
    public void setFavoritedto(FavoriteDto favoritedto) {
        this.favoritedto = favoritedto;
    }
    public UserPostImgFavoriteDto(){
        userdto = new UserDto();
        postdto = new PostDto();
        imgdto = new ImgDto();
        favoritedto = new FavoriteDto();
    }


}
