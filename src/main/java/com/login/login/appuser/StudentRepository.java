package com.login.login.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.DefaultEditorKit;
import javax.transaction.Transactional;
import java.util.Optional;
@Repository
@Transactional
public interface StudentRepository extends JpaRepository<AppUser,Long> {
    //Le type Optional est un conteneur qui peut contenir ou non une valeur. Il a été introduit dans Java 8 pour aider à éviter les NullPointerExceptions et à améliorer la lisibilité du code.
    Optional<AppUser>  findByEmail(String email);
}
//@Transactional est une annotation de Spring qui permet de définir le contexte transactionnel d'une méthode ou d'une classe. L'annotation indique que la méthode ou la classe doit être exécutée à l'intérieur d'une transaction, c'est-à-dire qu'elle doit être atomique et cohérente, et que les modifications apportées à la base de données doivent être soit toutes validées, soit toutes annulées si une erreur se produit.
//
//L'annotation @Transactional peut être placée sur une méthode ou sur une classe. Lorsqu'elle est placée sur une méthode, elle indique que cette méthode doit être exécutée dans un contexte transactionnel. Lorsqu'elle est placée sur une classe, elle s'applique à toutes les méthodes de la classe.
//Une transaction est une série d'opérations qui doivent être exécutées de manière atomique, c'est-à-dire que si l'une des opérations échoue, toutes les opérations doivent être annulées pour préserver l'intégrité de la base de données. Par exemple, si vous transférez de l'argent d'un compte à un autre, la transaction doit être effectuée de manière atomique pour éviter toute perte d'argent ou toute corruption de la base de données.