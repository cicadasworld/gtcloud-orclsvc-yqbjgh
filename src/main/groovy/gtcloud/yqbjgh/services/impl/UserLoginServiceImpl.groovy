package gtcloud.yqbjgh.services.impl

import gtcloud.yqbjgh.domain.Bdf2User
import gtcloud.yqbjgh.repositories.Bdf2UserRepository
import gtcloud.yqbjgh.security.authentication.encoding.ShaPasswordEncoder
import gtcloud.yqbjgh.services.UserLoginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    Bdf2UserRepository repository

    @Override
    String[] login(String username, String password) {
        final Bdf2User entity = repository.findByUsername(username)
        if (entity == null) {
            return ["false", "\u8f93\u5165\u7684\u53c2\u6570\u65e0\u6548"]
        }
        final String encPass = entity.getPassword()
        final String salt = entity.getSalt()
        ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder()
        boolean valid = passwordEncoder.isPasswordValid(encPass, password, salt)
        if (username == null || password == null) {
            return ["false", "\u8f93\u5165\u7684\u53c2\u6570\u65e0\u6548"]
        }
        if (valid) {
            return ["true", "\u767b\u5f55\u6210\u529f!"]
        } else {
            return ["false", "\u7528\u6237\u540d\u6216\u5bc6\u7801\u9519\u8bef"]
        }
    }
}
