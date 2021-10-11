package com.example.checkcompounds;

public class GoodAVITO extends Good{
   // private String title;
   // private String price; //TODO:изменить на int
    private String description;
    private String location;
  //  private String date_upload;




    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
