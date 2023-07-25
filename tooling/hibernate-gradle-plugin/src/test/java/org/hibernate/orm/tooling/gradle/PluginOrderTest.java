package org.hibernate.orm.tooling.gradle;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PluginOrderTest {

	@Test
	void pluginWorksIfNoJavaPlugin() {
		Project project = ProjectBuilder.builder().build();
		project.getPlugins().apply( "org.hibernate.orm" );

		assertThat( project.getExtensions().findByName( "hibernate" ) ).isNotNull();
	}

	@Test
	void pluginWorksIfAppliedBeforeJavaPlugin() {
		Project project = ProjectBuilder.builder().build();
		project.getPlugins().apply( "org.hibernate.orm" );
		project.getPlugins().apply( "java" );

		assertThat( project.getExtensions().findByName( "hibernate" ) ).isNotNull();
	}
}
