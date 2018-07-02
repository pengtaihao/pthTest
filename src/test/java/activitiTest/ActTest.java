package activitiTest;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class ActTest {
	ProcessEngine engines = ProcessEngines.getDefaultProcessEngine();
	
//	DeploymentEntity[id=2501, name=null]
//	DeploymentEntity[id=5001, name=null]
//	DeploymentEntity[id=7501, name=null]
	@Test	
	public void deploy() {
		Deployment deploy = engines.getRepositoryService()
				.createDeployment()
				.addClasspathResource("请假流程-排他网关.bpmn")
				.deploy();
		System.out.println(deploy);
	}
	
	@Test
	public void startProcess() {
		RepositoryService repositoryService = engines.getRepositoryService();
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
		PageInfo<ProcessDefinition> pageInfo = new PageInfo<ProcessDefinition>(list);
		System.out.println(pageInfo);
		long count = repositoryService.createProcessDefinitionQuery().count();
		System.out.println(count);
		System.out.println(list);
////		获取所有已部署的流程
//		 ProcessDefinition singleResult = repositoryService.createProcessDefinitionQuery().deploymentId("2501").singleResult();
//		 
//		
////		启动一个流程
//		RuntimeService runtimeService = engines.getRuntimeService();
//		System.out.println("启动前");
//		System.out.println(singleResult.getId());
//		ProcessInstance startProcessInstanceById = runtimeService.startProcessInstanceById(singleResult.getId());
//		System.out.println(startProcessInstanceById);
//		System.out.println("启动后");
	}
	
	@Test
	public void compeleteTask() {
		TaskService taskService = engines.getTaskService();
		List<Task> list = taskService.createTaskQuery().processInstanceId("17501").list();
//		for (Task task : list) {
//			taskService.complete(task.getId());
//			System.out.println(task.getName()+"==>完成");
//		}
		System.out.println(list);
	}
}
