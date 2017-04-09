package com.bandung.android.loginfirebaseapps;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by anggy on 02/04/2017.
 */
@IgnoreExtraProperties
public class Model {
    private String namalengkap,alamat,telpon,kelas;

    public Model(){

    }

    public Model(String namalengkap, String alamat, String telpon, String kelas) {
        this.namalengkap = namalengkap;
        this.alamat = alamat;
        this.telpon = telpon;
        this.kelas = kelas;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getTelpon() {
        return telpon;
    }

    public String getKelas() {
        return kelas;
    }
}
