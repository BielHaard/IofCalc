

@Entity
@Table(name = "cliente", uniqueConstraints = {
        @UniqueConstraint(columnNames = "documento")
})
public class Cliente{


    @Id
    private Long id;


    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoPessoa tipoPessoa;

    @Column(unique = true, nullable = false)
    private String documento;


    @Column
    private String nome;


}