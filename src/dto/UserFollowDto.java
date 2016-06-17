package com.mySNS.dto;

public class UserFollowDto {
    private UserDto userdto;
    private FollowDto followdto;
    public UserDto getUserdto() {
        return userdto;
    }
    public void setUserdto(UserDto userdto) {
        this.userdto = userdto;
    }
    public FollowDto getFollowdto() {
        return followdto;
    }
    public void setFollowdto(FollowDto followdto) {
        this.followdto = followdto;
    }
    public UserFollowDto(){
        userdto = new UserDto();
        followdto = new FollowDto();
    }

}
