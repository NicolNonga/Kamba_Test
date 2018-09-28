
package com.example.nicodemos.kamba_test.DadosAPIModelo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Nicodemos on 24/09/2018.
 */

public class KambaModel implements Parcelable{



   private  String id_user="";
   private  String intent="";
   private int amout;
   private int subtotal;
   private  int fee;
   private String id_from="";
   private String first_name;
   private  String lastname="";
   private  String phone_number="";
   private  String email_from="";
   private  String id_to="";
   private  String first_name_to="";
   private String  lastname_to="";
   private  String phone_number_to="";
   private  String email_to="";
   private String description="";





    public KambaModel(String id_user, String intent, int amout, int subtotal, int fee, String id_from, String first_name, String lastname, String phone_number, String email_from, String id_to, String first_name_to, String lastname_to, String phone_number_to, String email_to, String description) {
        this.id_user = id_user;
        this.intent = intent;
        this.amout = amout;
        this.subtotal = subtotal;
        this.fee = fee;
        this.id_from=id_from;
        this.first_name= first_name;
        this.lastname= lastname;
        this.phone_number= phone_number;
        this.email_from= email_from;
        this.id_to= id_to;
        this.first_name_to= first_name_to;
        this.lastname_to= lastname_to;
        this.phone_number_to= phone_number_to;
        this.email_to= email_to;
        this.description= description;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public int getAmout() {
        return amout;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getId_from() {
        return id_from;
    }

    public void setId_from(String id_from) {
        this.id_from = id_from;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail_from() {
        return email_from;
    }

    public void setEmail_from(String email_from) {
        this.email_from = email_from;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getId_to() {
        return id_to;
    }

    public void setId_to(String id_to) {
        this.id_to = id_to;
    }

    public String getFirst_name_to() {
        return first_name_to;
    }

    public void setFirst_name_to(String first_name_to) {
        this.first_name_to = first_name_to;
    }

    public String getLastname_to() {
        return lastname_to;
    }

    public void setLastname_to(String lastname_to) {
        this.lastname_to = lastname_to;
    }

    public String getPhone_number_to() {
        return phone_number_to;
    }

    public void setPhone_number_to(String phone_number_to) {
        this.phone_number_to = phone_number_to;
    }

    public String getEmail_to() {
        return email_to;
    }

    public void setEmail_to(String email_to) {
        this.email_to = email_to;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    private KambaModel(Parcel in){

         id_user=in.readString();
         intent=in.readString();
        amout= in.readInt();
        subtotal=in.readInt();
        fee= in.readInt();
        id_from=in.readString();
         first_name=in.readString();
        lastname=in.readString();
        phone_number=in.readString();
         email_from=in.readString();
        id_to=in.readString();
         first_name_to=in.readString();
        lastname_to=in.readString();
        phone_number_to=in.readString();
         email_to=in.readString();
         description=in.readString();

    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id_user);
        dest.writeInt(amout);
        dest.writeInt(subtotal);
        dest.writeInt(fee);
        dest.writeString(id_from);
        dest.writeString(first_name);
        dest.writeString(lastname);
        dest.writeString(phone_number);
        dest.writeString(email_from);
        dest.writeString(id_to);
        dest.writeString(first_name_to);
        dest.writeString(lastname_to);
        dest.writeString(phone_number_to);
        dest.writeString(email_to);
        dest.writeString(description);

    }

    // creating a Pareclable
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public KambaModel createFromParcel(Parcel in) {
            return new KambaModel(in);
        }

        public KambaModel[] newArray(int size) {
            return new KambaModel[size];
        }
    };
}
