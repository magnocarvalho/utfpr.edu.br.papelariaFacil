package utfpr.edu.br.papelariafacil.bo;

import utfpr.edu.br.papelariafacil.dao.DaoGenerics;
import utfpr.edu.br.papelariafacil.vo.Categoria;
import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import utfpr.edu.br.papelariafacil.dao.GenericDAO;

/**
 * @see Classe de objetos de negócios. Métodos: alterarCategoria(),
 * inserirCategoria(), validarCampos().
 * 
 */
public class CategoriaBO {

    /**
     * @see Método que persiste um objeto no banco de dados por meio da
     * GenericDAO.
     * @param descricao
     * @return true/false.
     */
    public Boolean inserirCategoria(String descricao) {
        try {
            GenericDAO<Categoria> categoriaDAO = new GenericDAO();
            Categoria categoriaVO = new Categoria();
            categoriaVO.setDescricaocategoria(descricao);
            
            if (categoriaDAO.inserir(categoriaVO)) {
                JOptionPane.showMessageDialog(null, "Categoria inserida com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * @see Método que altera um objeto no banco de dados por meio da
     * GenericDAO.
     * @param idCategoria
     * @param descricao
     * @return true/false.
     */
    public Boolean alterarCategoria(Long idCategoria, String descricao) {
        try {
            GenericDAO<Categoria> categoriaDAO = new GenericDAO();
           
             Categoria categoriaVO;
            categoriaVO = categoriaDAO.consultar("idcategoria", idCategoria, new Categoria());
            categoriaVO.setDescricaocategoria(descricao);
            
            if (categoriaDAO.atualizar(categoriaVO)) {
                JOptionPane.showMessageDialog(null, "Categoria alterada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * @see Método que verifica se os elementos do JPanel são diferentes de
     * null, usado para verificar se os campos estão preenchidos pelo usuário.
     * @param panel
     * @return false caso pelo menos um componente possuir getText() == null.
     */
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
