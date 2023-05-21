
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Cliente buscar(String dni){
        Cliente c = new Cliente();
        String sql="select * from Cliente where Dni="+dni;
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDir(rs.getString(4));
                c.setEs(rs.getString(5));
            }
        }catch(Exception e){
            System.out.println("error metodo buscar Cliente "+e.getMessage());
        }
        return c;
    }
    
    //Operaciones CRUD
    
    public List listar(){
        String sql="select *from cliente";
        List<Cliente>lista=new ArrayList<>();
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDir(rs.getString(4));
                c.setEs(rs.getString(5));
                lista.add(c);                
            }
        }catch(Exception e){
            System.out.println("error metodo listar Cliente"+e.getMessage());
        }
        return lista;
    }
    
    
    public int actualizar(Cliente c){
        String sql="update cliente set Dni=?, Nombres=?, Direccion=?, Estado=? where IdCliente=?";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, c.getDni());
            ps.setString(2, c.getNom());
            ps.setString(3, c.getDir());
            ps.setString(4, c.getEs());
            ps.setInt(5, c.getId());
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("error metodo actualizar Cliente "+e.getMessage());
        }
        return r;
    }
    public int agregar(Cliente c){
        String sql="insert into cliente(Dni, Nombres, Direccion, Estado)values(?,?,?,?)";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, c.getDni());
            ps.setString(2, c.getNom());
            ps.setString(3, c.getDir());
            ps.setString(4, c.getEs());
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("error metodo agregar Cliente "+e.getMessage());
        }
        return r;
    }
    public Cliente listarId(int id){
        Cliente c = new Cliente();
        String sql="select *from cliente where IdCliente="+id;
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDir(rs.getString(4));
                c.setEs(rs.getString(5));
            }
        }catch(Exception e){
            System.out.println("error metodo listarId Cliente "+e.getMessage());
        }
        return c;
    }
    public void delete(int id){
        String sql="delete from cliente where IdCliente="+id;
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println("error metodo delete Cliente "+e.getMessage());
        }
    }
}
