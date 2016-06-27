package com.company;
import java.util.ArrayList;
import java.io.*;

class Vertex// ����� �������
{
    char color;//���� ( 'g' - ����� , 'b' - ������, 'w' - ����� )
    int name; // ����� �������
    ArrayList<Edge> edg= new ArrayList<Edge>(); //������ ����� �� �������
    Vertex(int name) // �����������
    {
        this.color= 'w';   //������� � ���� ���� - �����
        this.name=name;    // �������� ����� �������
    }
};

class Edge // ����� �����
{
    Vertex v; // � ����� ������� ��� ����
    boolean used; // ������ �� �� ����� ����
    Edge(Vertex v) // �����������
    {
        this.v = v;
        this.used=false;
    }
};

class Tree //����� ������
{
    ArrayList<Vertex> vertices= new ArrayList<Vertex>();  // ������ ������
    ArrayList<Vertex> RTopSort= new ArrayList<Vertex>();     //������ ������ ������, ���������� � �������� �������
};

public class TopSort
{
    static char White='w'; //������ ����������� �����
    static char Black='b';
    static char Gray='g';
    static Tree tree=new Tree(); //�������� ������
    static void dfs1(Vertex cur) //����� � �������
    {
        cur.color=Gray; //������ ������� � �����
        for (int i = 0; i<cur.edg.size(); i++)
        {
            if (cur.edg.get(i).v.color==White)
            {
                cur.edg.get(i).used=true;// ������ �� �����
                dfs1(cur.edg.get(i).v);//��������� � ����. �������
            }
        }
        cur.color=Black;//����� �� ������� - ��������� � ������
        tree.RTopSort.add(cur);//�������� � � ������
    }

    static void TopSort() //�������������� ����������
    {
        tree.RTopSort.clear(); //������� ������ ������
        int m=0; // m -����� ������� ��� ������� ����� �������� ����� � �������
        while(tree.RTopSort.size()<tree.vertices.size()) //���� ��� ������� �� ������ � ����� ������
        {
            if((tree.vertices.get(m).color==White)) //���� ������� �� ��������
            {
                dfs1(tree.vertices.get(m)); // ��������� ����� � �������
            }
            else m++;//����� ��������� � ����������
        }
    }
    public static void main(String[] args) throws IOException
    {
     	//��������� ������
        TopSort(); // ������ �������������� ����������
        for(int i=0;i<tree.RTopSort.size();i++)
            System.out.print(tree.RTopSort.get(tree.RTopSort.size()-i-1).name); //������� �� ����� ��� �������� ������� ������ � �������� �������
    }
}
