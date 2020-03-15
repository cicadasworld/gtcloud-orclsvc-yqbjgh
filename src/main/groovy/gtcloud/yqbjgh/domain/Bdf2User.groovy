package gtcloud.yqbjgh.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "BDF2_USER")
class Bdf2User {

    @Id
    @Column(name = "USERNAME_")
    String username

    @Column(name = "PASSWORD_")
    String password

    @Column(name = "SALT_")
    String salt

}
