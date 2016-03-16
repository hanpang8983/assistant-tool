/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package util.mybatis.mapper;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import util.mybatis.utils.PropertieUtils;

/**
 * 
 * TODO.
 *
 * @author huanglicong
 * @version V1.0
 */
public class ExtendsDaoPlugin extends PluginAdapter {

	private FullyQualifiedJavaType dao;

	public ExtendsDaoPlugin() {

		this.dao = new FullyQualifiedJavaType(PropertieUtils.get("daoMapperPackage"));
	}

	@Override
	public boolean validate(List<String> warnings) {

		return true;
	}

	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

		interfaze.addImportedType(dao);
		interfaze.addSuperInterface(dao);
		return true;
	}

}
