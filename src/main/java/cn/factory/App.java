package cn.factory;

import cn.factory.dao.FactotyDao;
import cn.factory.entity.Factory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    static Scanner input=new Scanner(System.in);
    public static void main( String[] args )
    {
        //查询列表
        select();
        //模糊查询列表.
        // selectlike();
        //添加
        //add();
        //修改
        //update();
    }

    private static void update() {
        select();
        String xml="configuration.xml";
        try {
            InputStream is = Resources.getResourceAsStream(xml);
            SqlSessionFactoryBuilder sbf=new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sbf.build(is);
            SqlSession sqlSession = build.openSession();
            FactotyDao mapper = sqlSession.getMapper(FactotyDao.class);
            Factory f=new Factory();
            System.out.println("选择修改的编号");
            Integer id=input.nextInt();
            System.out.println("修改名称");
            String model=input.next();
            System.out.println("修改价格");
            double factor=input.nextDouble();
            System.out.println("修改时间");
            String date=input.next();
            f.setId(id);
            f.setModel(model);
            f.setFactoryprice(factor);
            f.setDateofproduction(date);
            boolean uodatefactory = mapper.uodatefactory(f);
            if(uodatefactory){
                //提交回话
                sqlSession.commit();
                System.out.println("成功");
            }else{
                System.out.println("失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void add() {
        String xml="configuration.xml";
        try {
            InputStream is=Resources.getResourceAsStream(xml);
            SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sfb.build(is);
            SqlSession sqlSession = build.openSession();
            FactotyDao mapper =(FactotyDao)sqlSession.getMapper(FactotyDao.class);
            System.out.println("输入编号");
            Integer id=input.nextInt();
            System.out.println("输入名称");
            String model=input.next();
            System.out.println("输入价格");
            double factor=input.nextDouble();
            System.out.println("输入时间");
            String date=input.next();
            Factory f=new Factory();
            f.setId(id);
            f.setModel(model);
            f.setFactoryprice(factor);
            f.setDateofproduction(date);
            boolean addfactory = mapper.addfactory(f);
            if (addfactory){
                sqlSession.commit();
                System.out.println("成功");
            }else{
                System.out.println("失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        select();
    }

    private static void select() {
        String xml="configuration.xml";
        try {
            InputStream is= Resources.getResourceAsStream(xml);
            SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sfb.build(is);
            SqlSession sqlSession = build.openSession();
            List<Factory> list=sqlSession.selectList("fd");
            for (Factory s:list) {
                System.out.println(s.getId()+s.getModel()+s.getFactoryprice()+s.getDateofproduction());
            }
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void selectlike() {
        String xml="configuration.xml";
        try {
            InputStream is= Resources.getResourceAsStream(xml);
            SqlSessionFactoryBuilder sfb=new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sfb.build(is);
            SqlSession sqlSession = build.openSession();
            FactotyDao factotyDao=  (FactotyDao)sqlSession.getMapper(FactotyDao.class);
            System.out.println("输入查询的关键字：");
            String like=input.next();
            List<Factory> c = factotyDao.vague(like);
            for (Factory f:c) {
                System.out.println(f.getId()+f.getModel());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
