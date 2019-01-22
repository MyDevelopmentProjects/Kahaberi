package ge.unknown.bootstrap;

import ge.unknown.data.repository.LanguageRepository;
import ge.unknown.data.repository.RoleRepository;
import ge.unknown.data.repository.ServerVariableRepository;
import ge.unknown.data.repository.UserRepository;
import ge.unknown.entities.Language;
import ge.unknown.entities.Role;
import ge.unknown.entities.ServerVariable;
import ge.unknown.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ServerVariableRepository serverVariableRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

    }

    /**
     * Initialize Spring data
     */
    private void initData(){
//        ServerVariable var = serverVariableRepository.findByServerKey("INIT_DATABASE");
//        if(var == null){
//            ServerVariable key = ServerVariable.builder()
//                    .serverKey("INIT_DATABASE")
//                    .serverVal("true")
//                    .build();
//            serverVariableRepository.save(key);
//
//            // ვქმნით ენებს
//            List<Language> langList = new ArrayList<>(3);
//            {
//                langList.add(Language.builder()
//                        .shortCode("GE")
//                        .displayName("ქართული")
//                        .build());
//                langList.add(Language.builder()
//                        .shortCode("EN")
//                        .displayName("English")
//                        .build());
//                langList.add(Language.builder()
//                        .shortCode("RU")
//                        .displayName("русский")
//                        .build());
//            }
//            languageRepository.save(langList);
//
//            // როლები
//            List<Role> roleList = new ArrayList<>(3);
//            {
//                roleList.add(Role.builder().name("ADMIN").build());
//                roleList.add(Role.builder().name("ORGANISATION").build());
//                roleList.add(Role.builder().name("NORMAL_USER").build());
//            }
//            roleRepository.save(roleList);
//
//
//            // უფლებები
//
//
//
//            // ვქმნით მომხმარებლებს
//            List<User> userList = new ArrayList<>(2);
//            {
//                Role adminRole = roleRepository.findByName("ADMIN");
//                List<Role> userRole = new ArrayList<>(1);
//                {
//                    if(adminRole != null){
//                        userRole.add(adminRole);
//                    }
//                }
//
//                // PasswordEncrypter
//                // TODO PASSWORD ENCRYPTER
//
//                // მიხეილ
//                userList.add(
//                    User.builder()
//                        .username("mjaniko").email("mjaniko@gmail.com")
//                        .firstName("Mikheil").lastName("Janiashvili")
//                        .password("123456789")
//                        .role(userRole)
//                        .active(true)
//                        .build()
//                );
//
//                // ვაშაკოვიჩ
//                userList.add(
//                    User.builder()
//                        .username("vashusha").email("gvashakidze6@gmail.com")
//                        .firstName("George").lastName("Vashakidze")
//                        .password("123456789")
//                        .role(userRole)
//                        .active(true)
//                        .build()
//                );
//                userRepository.save(userList);
//            }
//
//
//            // ვქმნით ორგანიზაციას
//           // Organisation organisation = Organisation.builder()
//
//
//
//
//            // მოგვაქვს ყველა ენა
//            List<Language> languages = languageRepository.findAll();
//            // ყველა ენისათვის ვქმნით ობიექტს
//            for(Language la : languages){
//
//            }
//
//
//        }

    }
}
