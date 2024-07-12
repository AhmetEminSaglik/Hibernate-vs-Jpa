package org.aes.compare.orm;

import org.aes.compare.orm.config.ORMConfigSingleton;
import org.aes.compare.orm.consoleapplication.AddressFacade;
import org.aes.compare.orm.consoleapplication.CourseFacade;
import org.aes.compare.orm.consoleapplication.StudentFacade;
import org.aes.compare.orm.model.Address;
import org.aes.compare.orm.model.courses.abstracts.Course;
import org.aes.compare.uiconsole.utility.SafeScannerInput;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ORMConfigSingleton orm = new ORMConfigSingleton();
    //    static SubaddressFacade addressFacade = new SubaddressFacade(orm.getAddressService());
    static AddressFacade addressFacade;// = new addressFacadeFacade(orm.getAddressService());
    static StudentFacade studentFacade;// = new studentFacadeFacade(orm.getStudentService(), orm.getAddressService());
    static CourseFacade courseFacade;// = new studentFacadeFacade(orm.getStudentService(), orm.getAddressService());
    public static void main(String[] args) {
        ORMConfigSingleton.enableJPA();
        addressFacade = new AddressFacade(orm.getAddressService());
        studentFacade = new StudentFacade(orm.getStudentService(),addressFacade,courseFacade);
        courseFacade= new CourseFacade();
/*

//        List<Address> tmpAddress = orm.getAddressService().findAllSavedAndNotMatchedAnyStudentAddress();
//        tmpAddress.forEach(System.out::println);

        int studentId=2;
        List<Course> tmpCourse = orm.getCourseService().findAllCourseOfStudentId(studentId);
        System.out.println("Student have : ");
        tmpCourse.forEach(System.out::println);

        tmpCourse = orm.getCourseService().findAllCourseThatStudentDoesNotHave(studentId);
        System.out.println("Student does not have : ");
        tmpCourse.forEach(System.out::println);

        System.exit(0);
*/

        int globalOption = -1;
        while (globalOption != 5) {
            System.out.println("1-) Address");
            System.out.println("2-) Student");
            System.out.println("3-) Course");
            System.out.println("4-) ExamResult");
            System.out.println("5-) Exit Program");
            System.out.print("Type one of the number :");
            globalOption = scanner.nextInt();
            scanner.nextLine();

            switch (globalOption) {
                case 1:
                    System.out.println("Leads to Address Process");
                    addressScenario();
                    break;
                case 2:
                    System.out.println("Leads to Student Process");
                    studentScenario();
                    break;
                case 3:
                    System.out.println("Leads to Course Process");
                    break;
                case 4:
                    System.out.println("Leads to Exam Result Process");
                    break;
                case 5:
                    System.out.println("Exitting the program");
                    break;
                default:
                    System.out.println("Invalid choose please try again!");
            }
        }

        /*addressFacade.save();

        System.out.println("Press enter  : ");
        scanner.nextLine();

        addressFacade.save();

        System.out.println("Press enter  : ");
        scanner.nextLine();

        addressFacade.findAll();

        System.out.println("Press enter  : ");
        scanner.nextLine();
*/
       /* addressFacade.findById();

        System.out.println("Press enter  : ");
        scanner.nextLine();

        addressFacade.update();

        System.out.println("Press enter  : ");
        scanner.nextLine();

        addressFacade.deleteById();

        System.out.println("Press enter  : ");
        scanner.nextLine();*/


        /*
//        UIConsoleApp consoleApp = new UIConsoleApp();
//        consoleApp.start();
        ORMConfigSingleton.enableJPA();

        Student student = new Student();
        student.setName("Ahmet");
        student.setGrade(3);

        Address address = new Address();
        address.setCity("city");
        address.setStreet("street");
        address.setCountry("Country");

        orm.getAddressService().save(address);

        student.setAddress(address);

//        student.addCourse(javaCourse);
        orm.getStudentService().save(student);

        Course javaCourse = new JavaCourse();
        javaCourse.addStudent(student);
        orm.getCourseService().save(javaCourse);*/
    }

    static void addressScenario() {
        int option = -1;
        while (option != 6) {
            System.out.println("1-) Save");
            System.out.println("2-) Find By Id");
            System.out.println("3-) Find All");
            System.out.println("4-) Update");
            System.out.println("5-) Delete");
            System.out.println("6-) Exit");

            System.out.println("select one option");
            option = SafeScannerInput.getIntRecursive();
//            scanner.nextLine();

            switch (option) {
                case 1:
                    addressFacade.save();
                    break;
                case 2:
                    addressFacade.findById();
                    break;
                case 3:
                    addressFacade.findAll();
                    break;
                case 4:
                    addressFacade.update();
                    break;
                case 5:
                    addressFacade.deleteById();
                    break;
                case 6:
                    System.out.println("exitting the address Service");
                    break;
                default:
                    System.out.println("Invalid Choose try again");
            }
        }
    }

    static void studentScenario() {
        int option = -1;
        while (option != 7) {
            System.out.println("1-) Save");
            System.out.println("2-) Find By Id");
            System.out.println("3-) Find All");
            System.out.println("4-) Find By Student Id And Course Name");
            System.out.println("5-) Update");
            System.out.println("6-) Delete");
            System.out.println("7-) Exit");

            System.out.println("select one option");
            option = SafeScannerInput.getIntRecursive();
//            scanner.nextLine();

            switch (option) {
                case 1:
                    studentFacade.save();
                    break;
                case 2:
                    studentFacade.findById();
                    break;
                case 3:
                    studentFacade.findAll();
                    break;
                case 4:
                    studentFacade.findByStudentIdWithCourseName();
                    break;
                case 5:
                    studentFacade.update();
                    break;
                case 6:
                    studentFacade.delete();
                    break;
                case 7:
                    System.out.println("Exiting the Student Service");
                    break;
                default:
                    System.out.println("Invalid Choose try again");
            }
        }
    }


    /*static class SubaddressFacade {
        private final AddressService addressService;
        private static int counter = 0;

        public SubaddressFacade(AddressService addressService) {
            this.addressService = addressService;
        }

        public void save() {
            counter++;
            System.out.println(ColorfulTextDesign.getInfoColorText(counter + "-) [ADDRESS] Save : "));
            Address address = new Address();
            address.setCity(counter + ". City");
            address.setStreet(counter + ". Street");
            address.setCountry(counter + ". Counter");


            addressService.save(address);
            System.out.println("Address is saved : " + address);
            System.out.println("----------------------------------");
        }

        public void findById() {
            counter++;
            System.out.println(ColorfulTextDesign.getInfoColorText(counter + "-) [ADDRESS] Find by id : "));
            System.out.print("Id no: ");
//            int id = scanner.nextInt();
            int id = SafeScannerInput.getIntRecursive();
            Address address = addressService.findById(id);
            addressService.findById(id);
            System.out.println("Address is Found: " + address);
            System.out.println("----------------------------------");

        }

        public void findAll() {
            counter++;
            System.out.println(ColorfulTextDesign.getInfoColorText(counter + "-) [ADDRESS] Find ALL : "));
            List<Address> addresses = addressService.findAll();
//            System.out.println("Addresses Found: " + addresses);
            addresses.forEach(e -> {
                System.out.println(e);
            });
            System.out.println("----------------------------------");

        }

        public void update() {
            counter++;
            System.out.println(ColorfulTextDesign.getInfoColorText(counter + "-) [ADDRESS] Update : "));
            System.out.print("Address Id no: ");
//            int id = scanner.nextInt();
            int id = SafeScannerInput.getIntRecursive();
            Address address = addressService.findById(id);
            addressService.findById(id);
            System.out.println("Address is Found: " + address);
            System.out.println("Update process is starting : ");


            int selected = 0;
            while (selected != 4) {
                System.out.println("1-) City");
                System.out.println("2-) Street");
                System.out.println("3-) Country");
                System.out.println("4-) Update and Exit");

                System.out.println("Current address data : ");
                System.out.println(address);
                selected = scanner.nextInt();
                scanner.nextLine();
                switch (selected) {
                    case 1:
                        System.out.print("Type City to update :");
                        address.setCity(scanner.nextLine());
                        break;
                    case 2:
                        System.out.print("Type Street to update :");
                        address.setStreet(scanner.nextLine());
                        break;
                    case 3:
                        System.out.print("Type Country to update :");
                        address.setCountry(scanner.nextLine());
                        break;
                    case 4:
                        addressService.update(address);
                        System.out.println("Address is updated : " + address);
                        break;
                    default:
                        System.out.println("Invalid choice try again");
                }
            }
            System.out.println("----------------------------------");
        }

        public void deleteById() {
            counter++;
            System.out.println(ColorfulTextDesign.getInfoColorText(counter + "-) [ADDRESS] Delete By Id : "));
            System.out.print("Id no: ");
            int id = scanner.nextInt();
            Address address = addressService.findById(id);
            addressService.findById(id);
            System.out.println("Address is Found: " + address);
            addressService.deleteById(id);
            System.out.println("address is deleted : ");
            System.out.println("----------------------------------");

        }

        public void resetTable() {
        }
    }*/


}