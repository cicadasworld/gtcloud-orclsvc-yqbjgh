package gtcloud.yqbjgh.repositories

import gtcloud.yqbjgh.domain.TxzhTsBddwml
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface TxzhTsBddwmlRepository extends JpaRepository<TxzhTsBddwml, String> {

    @Query("select t from TxzhTsBddwml t where t.parentnm = :id")
    List<TxzhTsBddwml> findByParentnm(@Param("id") String id)

    //@Query("select t from TxzhTsBddwml t where t.parentnm is null")
    List<TxzhTsBddwml> findByParentnmIsNull()

    @Query(value = "select t.nm from TxzhTsBddwml t where t.nm like :id%")
    List<String> findBdnmFamily(@Param("id") String id)

}
