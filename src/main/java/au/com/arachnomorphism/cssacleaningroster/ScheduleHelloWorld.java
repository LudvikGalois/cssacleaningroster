package au.com.arachnomorphism.cssacleaningroster;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class ScheduleHelloWorld {
    public static void main(String[] args) {
        SolverFactory<Schedule> solverFactory = SolverFactory.createFromXmlResource(
                "scheduleSolverConfig.xml");
        Solver<Schedule> solver = solverFactory.buildSolver();

        ArrayList<Person> people = new ArrayList();
        HashSet<String> probieSkills = new HashSet();
        probieSkills.add("Exec");
        people.add(DomainFactory.createPerson("Probie", probieSkills));
        people.add(DomainFactory.createPerson("Dave", new HashSet()));
        ArrayList<ScheduleItem> tasks = new ArrayList();
        ArrayList<String> neededSkills = new ArrayList();
        neededSkills.add("Exec");
        Task vacuum = DomainFactory.createTask("vacuum", neededSkills);
        Task mop = DomainFactory.createTask("mop", neededSkills);
        Day day = DomainFactory.createDay(LocalDate.parse("2018-03-02"));
        tasks.add(DomainFactory.createScheduleItem(day, vacuum));
        tasks.add(DomainFactory.createScheduleItem(day, mop));
        Schedule schedule = DomainFactory.createSchedule(people, tasks);

        for (ScheduleItem x : schedule.getTasks()) {
            System.out.println(x);
        }

        System.out.println("Solving");
        Schedule solvedSchedule = solver.solve(schedule);
        System.out.println("Solved");

        for (ScheduleItem x : solvedSchedule.getTasks()) {
            System.out.println(x);
        }


    }
}
