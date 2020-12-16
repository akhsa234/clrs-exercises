//package com.bahar.blog.seed;
//
//import com.bahar.blog.model.Tag;
//import com.bahar.blog.repository.TagRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class TagInitilizer implements CommandLineRunner {
//
//    private TagRepository tagRepository;
//    @Autowired
//    public TagInitilizer(TagRepository tagRepository) {
//        this.tagRepository = tagRepository;
//    }
//
//
//    @Override
//    public void run(String... args) throws Exception {
//
//      Tag tag= new Tag();
//      tag.setName("java");
//      tag.setDescription("Java is a class-based, object-oriented programming " +
//              "language that is designed to have as few implementation dependencies as possible.");
//      tag.setLockVersion(22);
//      tagRepository.save(tag);
//
//        Tag tag1= new Tag();
//        tag1.setName("css");
//        tag1.setDescription("Cascading Style Sheets is a style sheet language used for " +
//                "describing the presentation of a document written in a markup language such as HTML. " +
//                "CSS is a cornerstone technology of the World Wide Web, alongside HTML and JavaScript.");
//        tag1.setLockVersion(202);
//        tagRepository.save(tag1);
//
//        Tag tag2= new Tag();
//        tag2.setName("HTML");
//        tag2.setDescription("Hypertext Markup Language is the standard markup language for documents designed to" +
//                " be displayed in a web browser. It can be assisted by technologies" +
//                " such as Cascading Style Sheets and scripting languages such as JavaScript.");
//        tag2.setLockVersion(2002);
//        tagRepository.save(tag2);
//
//        Tag tag3= new Tag();
//        tag3.setName("JavaScript");
//        tag3.setDescription("JavaScript, often abbreviated as JS, is a programming language that conforms to " +
//                "the ECMAScript specification. JavaScript is high-level, often just-in-time compiled, " +
//                "and multi-paradigm. It has curly-bracket syntax, " +
//                "dynamic typing, prototype-based object-orientation, and first-class functions.");
//        tag3.setLockVersion(20002);
//        tagRepository.save(tag3);
//    }
//}
