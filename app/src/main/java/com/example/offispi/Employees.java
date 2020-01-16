package com.example.offispi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Employees {

    private static Map<String,String> DisplayNames = new HashMap<String,String>()
    {{
        put("yakir","Yakir Helets");
        put("yoel","Yoel Svarter");
        put("guyso","Guy Sofer");
        put("uri","Uri Dvir");
        put("vladimir","Vladimir Mutchnik");
        put("afik","Afik Bar");
        put("rotem","Rotem Klorin");
        put("tali","Tali Berkovitch");
        put("adi","Adi Avram");
        put("leon","Leon Landman");
        put("guys","Guy Schetrit");
        put("genna","Gennady Lisiansky");
        put("alexg","Alex Geyzner");
        put("michael","Michael Hefetz");
        put("oren","Oren Tamir");
        put("ron","Ron Sigal");
        put("pavel","Pavel Liahovetsky");
        put("dima","Dmitry Liahovetsky");
        put("arthur","Arthur Furman");
    }};

    public static List<Employee> employees = new  LinkedList<Employee>() { };

    public static void UpdateEmployees(JSONArray arr)
    {
        try
        {
            employees.clear();
            for (int i =0; i<arr.length();i++ )
            {
                JSONObject emp = arr.getJSONObject(i);
                Employee employee = new Employee(emp.getString("name"),DisplayNames.get(emp.getString("name")),emp.getInt("present")==1);
                employees.add(employee);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<String> getDisplayNames()
    {
        ArrayList<String> arr = new ArrayList<String>();
        for ( Employee employee : employees ) {

            arr.add(employee.getDisplayName());
        }
        return (arr);
    }
}
