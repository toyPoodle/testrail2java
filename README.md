# testrail2java

The target of this project to offer a pure java API to use TestRail. It also aims to hide URL handling and response processing from the user as much as possible.
The library is designed to use as few external libraries as possible to achieve its goal without reinventing the wheel.

TestRail: http://www.gurock.com/testrail/
TestRail API docs: http://docs.gurock.com/testrail-api2/start

## Quick start

The central class to start is the TestRailAPI class.

	> final TestRailAPI api = new TestRailAPI("https://<yourdomain>", "<username>", "<password>");

From there you select the controller of the type you want to modify (in this case you want to add a project, so *projects()*) and select the operation.
Objects received and returned by the API are immutable. When you create or update an object, a new instance of it with updated fields is created.

	> final Project project = api.projects().addProject(new Project("This is an example project", "Example Project", true, SuiteMode.MULTIPLE_SUITES));

You continue to prepare everything for a test run. If you don't want to supply optional parameters, you can put *null* in the parameter list.
	> final Suite suite = api.suites().addSuite(new Suite("This is an example suite", "Example Suite", project.getId()));
	> final Section section = api.sections().addSection(project.getId(), new Section("this is an example section", suite.getId(), null, "Example Section"));
	> final Type functionalityType = api.types().getCaseTypes().stream().filter(type -> type.getName().equals("Functionality")).findFirst().get();
	> final Priority priority = api.priorities().getPriorities().stream().findFirst().get();
	> final Case testCase = api.cases().addCase(new Case(section.getId(), "TestCase", functionalityType.getId(), priority.getId(), null, null, null, null, null, null));

Now you create the run with the id of the test case created previously
	> final Run run = api.runs().addRun(new Run(project.getId(), suite.getId(), "Example Run", "This is an example run", null, null, false, Collections.singletonList(testCase.getId())));

Let's assume that the test passed
	> final Status passed = api.statuses().getStatuses().stream().filter(status -> status.getName().equals("passed")).findFirst().get();
	> api.results().addResultForCase(run.getId(), testCase.getId(), new Result(passed.getId(), "test passed!", null, null, null, null, null, null));

Finished!
	> api.runs().closeRun(run.getId());


