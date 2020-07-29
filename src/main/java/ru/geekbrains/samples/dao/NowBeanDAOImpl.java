package ru.geekbrains.samples.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NowBeanDAOImpl implements NowBeanDAO {
    @Override
    public String getNow() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }
}
