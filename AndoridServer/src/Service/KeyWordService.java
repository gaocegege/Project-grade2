package Service;

import java.util.Arrays;
import java.util.List;

import org.fnlp.app.keyword.AbstractExtractor;
import org.fnlp.app.keyword.WordExtract;

import edu.fudan.nlp.cn.tag.CWSTagger;
import edu.fudan.nlp.corpus.StopWords;
import edu.fudan.util.exception.LoadModelException;

public class KeyWordService 
{
    //,     ;.      .                                                                     
    //rAG88888XAG88888&G     .X&;   GBs   .SB1   .rssssssssriirsssssssi  193SS33333S8888398Gi                     
    //h@91hhh1A@ShhhhhM#   .,:rHMr;;;&Ai;i&#5;,, :XXXXXXXXXX@@BXXXXXX&3  ;r9@8ri;3@3;;::9Bs.                      
    //1@GSSSSSA@9SSSSSBB   s@&898888899888899GMA           9@8.          :;rX#h;;rAM1ii3@Xs;,                     
    //h@GS5S99H@9S55S3##   1@1 ..,,,,,,,,,,.  BM         sM@9           ,@HS5SSGA95S3333S59@8                     
    //;353XAA9s;rhGB8rhh   ,s,r#AGGGGGGGGGGM& ir       i&@8H#,i&9r      sH8ssriA@hssssssss1HG:                    
    // ;XA&89GA&89SSr         s@5   ,Hh    MB        r&@X; &@,.s8BBGs.  s5S359@Hh5SSSSSS55S5S;                    
    //.;s59GG831riiG#&1       s@S   S@5.  .MB    .:SHM8;   A@:    sGMM9.    :H@HS399993S8XS                       
    //;&X&AG938#A333SSXHr     r@h  5@&#9  .BH ,h:iHAh.     A@:      .1r   ,8#31BH5;,,;h&@&r                       
   //.:1S88,  :@3  SG3S9i.     ;r3H#S,@8      h@h .        A@:          r8B8,   hABG8BH3:                         
   //,8X95i1933A#r  .:sS9&1 s9G&AHGh.  AM933339MH,          H@:         .891hS8GXGXX93XXGXXX89:                    
   //.    .rs1r,           r3hr:       i111111i            h3.            :93hsi,      ,;ishh.                    
                                                                                               
	public List<String> getImportant(String content)
	{
		try {
			// get the stopwords
			StopWords sw= new StopWords("models/stopwords");
			CWSTagger seg;
			seg = new CWSTagger("models/seg.m");
			AbstractExtractor key = new WordExtract(seg,sw);
			
			String keyWords = key.extract(content, content.length() / 100, true);
			String[] buf = keyWords.substring(1, keyWords.length() - 1).split(",");
			List<String> result = Arrays.asList(buf);
			return result;
		} catch (LoadModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		try {
			StopWords sw= new StopWords("models/stopwords");
			CWSTagger seg;
			seg = new CWSTagger("models/seg.m");
			AbstractExtractor key = new WordExtract(seg,sw);
			
			String keyWords = key.extract("�»��籱��7��7��ר�磨����Ǯ���ң��տ�ֱ������˾7�����ҹ�����ͨ�ú�����ҵǩ���ܼ�123��ֱ�����󵥡�ֱ��������Ϊ�ҹ�ͨ�ú����г�Ѹ�ٷ�չ���������㡣��Ϥ����������ͨ�ú������޹�˾��������ǩ��Э�鶩��55�ܿտ�ֱ�������͵���������˫��ֱ�����������ҹ���������ִ��ũҵ�͹�����������5�����Կտ�ֱ����С��������AS350B3eֱ�������꽻��������50����С��������EC135�������͵���������˫��ֱ������ɣ�Ԥ��6���ڽ������㶫����ͨ�ú������޹�˾����50�ܿտ�ֱ������Ʒ�����������ں��ϡ��㽭�͹㶫��ֱ�����ѾȺͽ���ҽ�ƾȻ��Լ�������з��񡣴˶������������ڿտ�ֱ����С��������EC135��������͵���������˫��ֱ������δ��10�����У�����ͨ����½������1��EC130T2��3��EC135T2e������46�ܷɻ�Ԥ����δ��5���ڽ������㶫����ͨ�����³�������˵���ҹ���Ա�������˿��ڶ࣬��ֱ��������ҽ�ƾȻ�������Ѿȷ����кܴ����󡣰���ͨ����EC135T2e��װ��ȫ����ص�ҽ��ϵͳ���豸�����⣬���Ϸ���ͨ�ú������޹�˾��տ�ֱ��������18��AS350B3eֱ����������4��AS350B3e�»����ڽ����ڽ���������14�ܻ����ڽ�������ڵ����ִ�п���������������к�ҽ�ƽ�����Ԯ�ȷ��񡣿տ�ֱ����ԭ��ŷ��ֱ������˾���ǿտͼ���ȫ�ʿع��ӹ�˾��", 2, true);
			//maybe wrong
			String[] hehe = keyWords.substring(1, keyWords.length() - 1).split(",");
			List<String> cece =  Arrays.asList(hehe);
			//�����Ѿ��ֺôʵľ���
			//sw=null;
			//key = new WordExtract(seg,sw);
			//System.out.println(key.extract("�»��籱��7��7��ר�磨����Ǯ���ң��տ�ֱ������˾7�����ҹ�����ͨ�ú�����ҵǩ���ܼ�123��ֱ�����󵥡�ֱ��������Ϊ�ҹ�ͨ�ú����г�Ѹ�ٷ�չ���������㡣��Ϥ����������ͨ�ú������޹�˾��������ǩ��Э�鶩��55�ܿտ�ֱ�������͵���������˫��ֱ�����������ҹ���������ִ��ũҵ�͹�����������5�����Կտ�ֱ����С��������AS350B3eֱ�������꽻��������50����С��������EC135�������͵���������˫��ֱ������ɣ�Ԥ��6���ڽ������㶫����ͨ�ú������޹�˾����50�ܿտ�ֱ������Ʒ�����������ں��ϡ��㽭�͹㶫��ֱ�����ѾȺͽ���ҽ�ƾȻ��Լ�������з��񡣴˶������������ڿտ�ֱ����С��������EC135��������͵���������˫��ֱ������δ��10�����У�����ͨ����½������1��EC130T2��3��EC135T2e������46�ܷɻ�Ԥ����δ��5���ڽ������㶫����ͨ�����³�������˵���ҹ���Ա�������˿��ڶ࣬��ֱ��������ҽ�ƾȻ�������Ѿȷ����кܴ����󡣰���ͨ����EC135T2e��װ��ȫ����ص�ҽ��ϵͳ���豸�����⣬���Ϸ���ͨ�ú������޹�˾��տ�ֱ��������18��AS350B3eֱ����������4��AS350B3e�»����ڽ����ڽ���������14�ܻ����ڽ�������ڵ����ִ�п���������������к�ҽ�ƽ�����Ԯ�ȷ��񡣿տ�ֱ����ԭ��ŷ��ֱ������˾���ǿտͼ���ȫ�ʿع��ӹ�˾��", 20));
			//System.out.println(key.extract("�Լ��� �� ���� ���� ����", 5));
			
			key = new WordExtract();
			System.out.println(key.extract("", 5));
		} catch (LoadModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
