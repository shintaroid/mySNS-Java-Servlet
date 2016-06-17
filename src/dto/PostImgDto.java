package com.mySNS.dto;

public class PostImgDto {
    private PostDto postdto;
    private ImgDto imgdto;
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
    public PostImgDto(){
        postdto = new PostDto();
        imgdto = new ImgDto();
    }
}
