package com.sait.summarize;

import java.util.List;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Developer;
import org.apache.maven.model.Plugin;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

@Mojo(name = "summarize", defaultPhase = LifecyclePhase.COMPILE)
public class SummarizeGoal extends AbstractMojo{
	
	@Parameter(defaultValue = "${project}", required = true)	
	private MavenProject project;
	
//	@Parameter
//	private String outputFile;
	
	public void execute() throws MojoExecutionException, MojoFailureException {
		
		getLog().info("Project Info: " + project.getGroupId() + "." + project.getArtifactId() + "." + project.getVersion());
		
		
		List<Dependency> dependencies = project.getDependencies();
				
		for(Dependency d: dependencies){
			getLog().info("Project Info: " + d.getGroupId() + "." + d.getArtifactId() + "." + d.getVersion());
			System.out.println("-------------------------------------------------------");			
		}
				
		
		List<Developer> developers = project.getDevelopers();
		
		for(Developer d: developers){
			getLog().info("Developer " + d.getId() + " Name: " + d.getName());
			System.out.println("-------------------------------------------------------");	
		}
			
		List<Plugin> plugins = project.getBuildPlugins();
		
		for(Plugin p: plugins){
			getLog().info("Plugin: " + p.getArtifactId());
			System.out.println("-------------------------------------------------------");	
		
		
		}
	}
	

}
