package activitiTest;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

public class Test {
	public static void main(String[] args) {
	
	}
	@org.junit.Test
	public void test() {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		System.out.println(engine.getClass());
//		创建一次部署
			RepositoryService repositoryService = engine.getRepositoryService();
			Deployment deployment = repositoryService.createDeployment().addClasspathResource("MyProcess.bpmn").deploy();
			System.out.println(deployment);
	}
}
