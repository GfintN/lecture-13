package by.it.academy.example.dao;


import by.it.academy.example.entity.CommandsSQL;
import by.it.academy.example.entity.UserInformationJDBC;
import by.it.academy.example.entity.TestDaoListTestDbParameter;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Component
public class JdbcTestDbDaoImpl implements JdbcTestDbDAO{
    private Connection connection;


    public void openConnection() {
        UserInformationJDBC uInfo = new UserInformationJDBC();
        connection = uInfo.getPoolConnection();
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ps;
    }

    private void closePrepareStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public CommandsSQL save(CommandsSQL id) throws SQLException {
        connection.setAutoCommit(false);
        String sql = id.getInsert();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int count = statement.executeUpdate();
            connection.commit();
            return id;
        } catch (Exception e) {
            connection.rollback();
            return id;
        }finally {
            connection.setAutoCommit(true);
        }

    }

    @Override
    public CommandsSQL get(CommandsSQL id) throws SQLException {
        String sql = id.getSelect();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet count = statement.executeQuery();
            return id;
        } catch (Exception e) {
            return id;
        }
    }

    @Override
    public int update(CommandsSQL id) throws SQLException {
        String sql = id.getUpdate();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            return statement.executeUpdate();

        }
    }

    @Override
    public int delete(CommandsSQL id) throws SQLException {
        String sql = id.getDelete();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int count = statement.executeUpdate();
            if (count != 1) {
                return count;
            } else {
                return count;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<String> getAllTestDbParameter(CommandsSQL id) throws SQLException {
        LinkedList lst = new LinkedList();
        try (PreparedStatement ps = connection.prepareStatement(id.getSelect())){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TestDaoListTestDbParameter user = new TestDaoListTestDbParameter();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setNumber(rs.getInt(3));
                lst.add(String.valueOf(user));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lst;
    }

    @Override
    public int getOneByTwo(CommandsSQL id) throws SQLException {
        String sql = id.getJoin();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet count = statement.executeQuery();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
