package by.it.academy.example.service;

import by.it.academy.example.dao.JdbcTestDbDAO;
import by.it.academy.example.entity.CommandsSQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class JdbcTestDbService {
    private final Logger logger = LoggerFactory.getLogger("LOGS");
    private CommandsSQL sql;
    private StringBuilder builder;

    @Autowired
    @Qualifier("jdbcTestDbDaoImpl")
   private JdbcTestDbDAO jdbcTestDbDAO;

    public void getJdbcTestDbDAO(JdbcTestDbDAO jdbcTestDbDAO){
        this.jdbcTestDbDAO = jdbcTestDbDAO;
    }

    public void addData(String id, String name, String number){
        sql = new CommandsSQL();
        builder = new StringBuilder();
        builder.append("id=").append(id).append(",name=").append(name).append(",number=").append(name);
        sql.setInsert("test_db.jdbc_test",String.valueOf(builder));
        try {jdbcTestDbDAO.save(sql);
        } catch (SQLException e) {
            logger.error("Fail Add in JdbcTestDbService",e);
        }
    }

    public void chengData(String id, String name, String number){
        sql = new CommandsSQL();
        builder = new StringBuilder();
        builder.append("id=").append(id).append(",name=").append(name).append(",number=").append(name);
        sql.setUpdate("test_db.jdbc_test",String.valueOf(builder));
        try {jdbcTestDbDAO.update(sql);
        } catch (SQLException e) {
            logger.error("Fail Cheng in JdbcTestDbService",e);
        }
    }
    public void deleteData(String id, String name, String number){
        sql = new CommandsSQL();
        builder = new StringBuilder();
        builder.append("id=").append(id).append(",name=").append(name).append(",number=").append(name);
        sql.setDelete("test_db.jdbc_test",String.valueOf(builder));
        try {jdbcTestDbDAO.delete(sql);
        } catch (SQLException e) {
            logger.error("Fail Delete in JdbcTestDbService",e);
        }
    }

    public void selectData(String id, String name, String number){
        sql = new CommandsSQL();
        builder = new StringBuilder();
        builder.append("id=").append(id).append(",name=").append(name).append(",number=").append(name);
        sql.setSelect("test_db.jdbc_test",String.valueOf(builder));
        try {jdbcTestDbDAO.get(sql);
        } catch (SQLException e) {
            logger.error("Fail Select in JdbcTestDbService",e);
        }
    }

    public void joinData(String tableJoin, String columnOne, String columnTwo){
        sql = new CommandsSQL();
        sql.setJoin("test_db.jdbc_test",tableJoin,columnOne,columnTwo);
        try {jdbcTestDbDAO.getOneByTwo(sql);
        } catch (SQLException e) {
            logger.error("Fail Join in JdbcTestDbService",e);
        }
    }

}
