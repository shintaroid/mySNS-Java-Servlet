package com.mySNS.dto;

public class UserFavoriteDto {
    private UserDto userdto;
    private FavoriteDto favoritedto;
    public UserDto getUserdto() {
        return userdto;
    }
    public void setUserdto(UserDto userdto) {
        this.userdto = userdto;
    }
    public FavoriteDto getFavoritedto() {
        return favoritedto;
    }
    public void setFavoritedto(FavoriteDto favoritedto) {
        this.favoritedto = favoritedto;
    }
    public UserFavoriteDto(){
        userdto = new UserDto();
        favoritedto = new FavoriteDto();
    }

}
