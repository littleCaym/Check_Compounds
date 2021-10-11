package com.example.checkcompounds;

import java.util.ArrayList;
import java.util.List;

public class Links {
    //OZON links:
    private static String POISK_KOMBIKORM_DLYA_TELYAT = "https://www.ozon.ru/category/tovary-dlya-fermerskogo-hozyaystva-34997/?from_global=true&text=%D0%BA%D0%BE%D0%BC%D0%B1%D0%B8%D0%BA%D0%BE%D1%80%D0%BC+%D0%B4%D0%BB%D1%8F+%D1%82%D0%B5%D0%BB%D1%8F%D1%82";

    private static String DLYA_TELYAT_DO_4_MESYATSEV_POLNOTSENNIY_KOMBIKORM = "https://www.ozon.ru/product/dlya-telyat-do-4-h-mesyatsev-polnoratsionnyy-kombikorm-granuly-10-kg-198854956/?asb=GCWKtBpt2zGSVIzjUlZkJNvaV%252FmOyZJDkRc8pO1RaPo%253D&asb2=DJ-8fx_efw9Cl16ZizyzM_3Bmu5zJLkmN5DHcwmdLbo&keywords=%D0%BA%D0%BE%D0%BC%D0%B1%D0%B8%D0%BA%D0%BE%D1%80%D0%BC+%D0%B4%D0%BB%D1%8F+%D1%82%D0%B5%D0%BB%D1%8F%D1%82&sh=KT4t1rqw";
    private static String KOMBIKORM_DLYA_TELYAT_V_VOZRASTE_DO_4_MESYATSEV_START = "https://www.ozon.ru/product/kombikorm-dlya-telyat-v-vozraste-do-4-mesyatsev-start-granula-202088121/?asb=QgHGXuzEfBqhOQhr0w6OrwOF0dkh9dqtA1uvbHWaW1A%253D&asb2=Yn4ULgKMFK_RUbefsEHeNuQwwPD3HYoVo_ursX5k-Bc&keywords=%D0%BA%D0%BE%D0%BC%D0%B1%D0%B8%D0%BA%D0%BE%D1%80%D0%BC+%D0%B4%D0%BB%D1%8F+%D1%82%D0%B5%D0%BB%D1%8F%D1%82&sh=eJXY0F4p";
    private static String KOMBIKORM_GAVRUSHA_S_STARTER_DLYA_TELYAT_25KG = "https://www.ozon.ru/product/kombikorm-gavryusha-s-starter-dlya-telyat-25kg-299171352/?asb=AuY1LAxD5J%252BlAe8n1v9yfr6lrmGYwMFkqaoqBiFJff8%253D&asb2=5lvEqonClVI9IxHmVsB_awIzIobxr1JbKiF0jCBRlTQ&keywords=%D0%BA%D0%BE%D0%BC%D0%B1%D0%B8%D0%BA%D0%BE%D1%80%D0%BC+%D0%B4%D0%BB%D1%8F+%D1%82%D0%B5%D0%BB%D1%8F%D1%82&sh=JURqkgl3";
    private static String KOMBIKORM_GAVRUSHA_PS_PRESTARTER_DLYA_TELYAT_25KG = "https://www.ozon.ru/product/kombikorm-gavryusha-ps-prestarter-dlya-telyat-25kg-299049850/?asb=tZm8q9LFyLnBs8Jb0zw9gJkZ%252BvDFMDSPyKrG3MIoPwY%253D&asb2=Mw4a64-saeyDvGRojeBcEpSvaIPOliTbnGV3bBfW8H4jCpJ5HjGmGhhnp6bTwbB8&keywords=%D0%BA%D0%BE%D0%BC%D0%B1%D0%B8%D0%BA%D0%BE%D1%80%D0%BC+%D0%B4%D0%BB%D1%8F+%D1%82%D0%B5%D0%BB%D1%8F%D1%82&sh=ZwtWunpZ";
    //AVITO links:
    private static String SEARCH_KOMBIKORM_FOR_KRS_MOSKVA_AND_MO = "https://www.avito.ru/moskva_i_mo/tovary_dlya_zhivotnyh?q=%D0%BA%D0%BE%D0%BC%D0%B1%D0%B8%D0%BA%D0%BE%D1%80%D0%BC+%D0%B4%D0%BB%D1%8F+%D0%BA%D1%80%D1%81";

    //Получаем ссылки на продукты с ОЗОН:
    public static ArrayList<String> getOZONDescriptionLinks(){
        ArrayList<String> stringArrayList = new ArrayList<>();

        stringArrayList.add(DLYA_TELYAT_DO_4_MESYATSEV_POLNOTSENNIY_KOMBIKORM);
        stringArrayList.add(KOMBIKORM_DLYA_TELYAT_V_VOZRASTE_DO_4_MESYATSEV_START);
        stringArrayList.add(KOMBIKORM_GAVRUSHA_S_STARTER_DLYA_TELYAT_25KG);
        stringArrayList.add(KOMBIKORM_GAVRUSHA_PS_PRESTARTER_DLYA_TELYAT_25KG);

        return stringArrayList;
    }

    public static ArrayList<String> getOZONSearchLinks(){
        ArrayList<String> stringArrayList = new ArrayList<>();

        stringArrayList.add(POISK_KOMBIKORM_DLYA_TELYAT);

        return stringArrayList;
    }

    public static ArrayList<String> getAVITOLinks(){
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add(SEARCH_KOMBIKORM_FOR_KRS_MOSKVA_AND_MO);
        return stringArrayList;
    }

    public static String getSEARCH_KOMBIKORM_FOR_KRS_MOSKVA_AND_MO() {
        return SEARCH_KOMBIKORM_FOR_KRS_MOSKVA_AND_MO;
    }
}
