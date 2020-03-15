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
    private Bdf2UserRepository repository

    @Override
    String[] login(String username, String password) {
        final Bdf2User entity = repository.findByUsername(username)
        if (entity == null) {
            return ["false", "����Ĳ�����Ч"]
        }
        final String encPass = entity.getPassword()
        final String salt = entity.getSalt()
        ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder()
        boolean valid = passwordEncoder.isPasswordValid(encPass, password, salt)
        if (username == null || password == null) {
            return ["false", "����Ĳ�����Ч"]
        }
        if (valid) {
            return ["true", "��¼�ɹ�!"]
        } else {
            return ["false", "�û������������"]
        }
    }
}
