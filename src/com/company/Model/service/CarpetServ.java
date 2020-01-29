package com.company.service;

import com.company.entity.CarpetEnt;
import com.company.repository.CarpetRep;

import java.util.List;

public class CarpetServ {

    private CarpetServ(){}

    private static CarpetServ carServ = new CarpetServ();

    public static CarpetServ getInstance(){
        return carServ;
    }

    public void save(CarpetEnt carpetEnt) throws Exception{
        try (CarpetRep carpetRep = new CarpetRep()){
            carpetRep.insert(carpetEnt);
            carpetRep.commit();
        }
    }

    public void edit(CarpetEnt carpetEnt) throws Exception{
        try (CarpetRep carpetRep = new CarpetRep()){
            carpetRep.update(carpetEnt);
            carpetRep.commit();
        }
    }

    public void remove(long num) throws Exception{
        try (CarpetRep carpetRep = new CarpetRep()){
            carpetRep.delete(num);
            carpetRep.commit();
        }
    }

    public List<CarpetEnt> report() throws Exception{
        List<CarpetEnt> carpetEntList;
        try (CarpetRep carpetRep = new CarpetRep()){
            carpetEntList = carpetRep.select();
        }
        return carpetEntList;
    }
}
