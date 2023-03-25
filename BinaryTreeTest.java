import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Nicolle Gordillo
 *
 */
class BinaryTreeTest {

	@Test
    public void testInsertAndContains() {
        BinaryTree<String> tree = new BinaryTree<>();
        
        
        tree.insert(new Association<>("house", "casa", "loger"));
        tree.insert(new Association<>("dog", "perro", "chien"));
        tree.insert(new Association<>("homework", "tarea", "devoirs"));
        tree.insert(new Association<>("woman", "mujer", "femme"));
        tree.insert(new Association<>("town", "pueblo", "ville"));
        
        
        assertTrue(tree.contains("house"));
        assertTrue(tree.contains("dog"));
        assertTrue(tree.contains("homework"));
        assertTrue(tree.contains("woman"));
        assertTrue(tree.contains("town"));
        
        
        assertFalse(tree.contains("cat"));
        assertFalse(tree.contains("car"));
        assertFalse(tree.contains("city"));
    }
	
	@Test
    public void testgetValue() {
        BinaryTree<String> tree = new BinaryTree<>();
        
        
        tree.insert(new Association<>("house", "casa", "loger"));
        tree.insert(new Association<>("dog", "perro", "chien"));
        tree.insert(new Association<>("homework", "tarea", "devoirs"));
        tree.insert(new Association<>("woman", "mujer", "femme"));
        tree.insert(new Association<>("town", "pueblo", "ville"));
        
        
        assertEquals("casa",tree.getValue("house").getValue1());
    }

}
