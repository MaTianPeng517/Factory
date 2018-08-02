package cn.factory.dao;

import cn.factory.entity.Factory;

import java.util.List;

public interface FactotyDao {

    public List<Factory> fd();

    public List<Factory> vague(String model);

    public boolean addfactory(Factory factory);

    public boolean uodatefactory(Factory factory);

}
