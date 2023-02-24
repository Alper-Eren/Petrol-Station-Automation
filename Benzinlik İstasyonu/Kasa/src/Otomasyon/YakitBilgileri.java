/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Otomasyon;

import java.sql.*;

/**
 *
 * @author mustafa
 */
public class YakitBilgileri {

    SqlConnection connection;
    private Double[] yakitStoklari;
    private Double[] yakitFiyatlari;

    public YakitBilgileri() {
        connection = new SqlConnection();
        yakitStoklari = new Double[3];
        yakitFiyatlari = new Double[3];
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // below two lines are used for connectivity.

                        ResultSet rs = connection.executeQuery("SELECT * FROM Yakit");

                        int i = 0;
                        while (rs.next()) {
                            yakitStoklari[i] = rs.getDouble(3);
                            yakitFiyatlari[i] = rs.getDouble(4);
                            i++;
                        }
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        th.start();

    }

    public Double getStok(int id) {
        return yakitStoklari[id];
    }

    public Double getFiyat(int id) {
        return yakitFiyatlari[id];
    }

    public void setStok(int id, Double d) {
        yakitStoklari[id] = d;
    }

    public void setFiyat(int id, Double d) {
        yakitFiyatlari[id] = d;
    }

}
