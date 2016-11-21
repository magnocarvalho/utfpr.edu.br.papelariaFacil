package utfpr.edu.br.papelariafacil.bo;

import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * @see Classe de objetos de negócios. Métodos: alterarFornecedor(),
 * inserirFornecedor(), buscarPessoaFisica(), buscarPessoaJuridica(),
 * validarCampos().
 * @author Bruna Danieli Ribeiro Gonçalves, Márlon Ândrel Coelho Freitas
 */
public class FornecedorBO {

    /**
     * @see Método que inseri um objeto no banco de dados por meio da
     * GenericDAO.
     * @param cpf
     * @param taxa
     * @param rg
     * @param simples
     * @param fantasia
     * @param razao
     * @param cnpj
     * @param fundacao
     * @param fornecedor
     * @param nome
     * @param email
     * @param telefone
     * @param celular
     * @param endereco
     * @param cep
     * @param complemento
     * @param numero
     * @param bairro
     * @param cidade
     * @param estado
     * @param pessoa
     * @param nascimento
     * @param estadual
     * @param municipal
     * @param suframa
     * @param icms
     * @return true/false
     */
    /* */   
    public boolean validarCampos(JPanel panel) {
        Component componentes[] = panel.getComponents();
        boolean erro = true;
        for (Component c : componentes) {
            if (c instanceof JTextField) {
                if (((JTextField) c).isEnabled()) {
                    if (((JTextField) c).getText().trim().equals("")) {
                        ((JTextField) c).setBorder(new LineBorder(Color.RED));
                        erro = false;
                    } else {
                        ((JTextField) c).setBorder(new LineBorder(Color.LIGHT_GRAY));
                    }
                } else {
                    ((JTextField) c).setBorder(new LineBorder(Color.LIGHT_GRAY));
                }
            }
        }
        return erro;
    }
    
}
