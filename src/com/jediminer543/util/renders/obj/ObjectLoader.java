package com.jediminer543.util.renders.obj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.lwjgl.util.vector.Vector3f;

public class ObjectLoader {


	public static Model load(File f) throws IOException
	{
        BufferedReader reader = new BufferedReader(new FileReader(f));
        Model m = new Model();
        String line;
			while ((line = reader.readLine()) != null) {
			    String prefix = line.split(" ")[0];
			    if (prefix.equals("#")) {
			        continue;
			    } else if (prefix.equals("v")) {
			    	m.vertices.add(parseVertex(line));
			    } else if (prefix.equals("vn")) {
			    	m.normals.add(parseNormal(line));
			    } else if (prefix.equals("f")) {
			    }
			}
		reader.close();
		return m;
	}
	
	public static Vector3f  parseVertex(String line)
	{
		String[] split = line.split(" ");
		float x = Float.valueOf(split[1]);
		float y = Float.valueOf(split[2]);
		float z = Float.valueOf(split[3]);
		return new Vector3f(x,y,z);
		
	}
	
	public static Vector3f  parseNormal(String line)
	{
		String[] split = line.split(" ");
		float x = Float.valueOf(split[1]);
		float y = Float.valueOf(split[2]);
		float z = Float.valueOf(split[3]);
		return new Vector3f(x,y,z);
		
	}
	
	public static ArrayList<Vector3f>  parseFace(String line)
	{
		ArrayList<Vector3f> output = new ArrayList<Vector3f>();
		String[] split = line.split(" ");
		float x = Float.valueOf(split[1].split("//")[0]);
		float y = Float.valueOf(split[2].split("//")[0]);
		float z = Float.valueOf(split[3].split("//")[0]);
		output.add(new Vector3f(x,y,z));
		//float[] x = Float.valueOf(split[1].split(""));
		//float[] y = Float.valueOf(split[2]);
		//float[] z = Float.valueOf(split[3]);
		
		return output;
		
		
	}
}
