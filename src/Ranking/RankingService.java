package Ranking;

import java.util.*;
import java.util.stream.Collectors;

public class RankingService {

    private final Set<Aluno> alunos;

    public RankingService(Set<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Aluno> obterRankingOrdenado() {
        return alunos.stream()
                .sorted(
                        Comparator.comparing(Aluno::getNota).reversed()
                                .thenComparing(Aluno::getNome)
                )
                .collect(Collectors.toList());
    }

    public List<Aluno> obterAprovados() {
        return alunos.stream()
                .filter(a -> a.getNota() >= 6)
                .collect(Collectors.toList());
    }

    public DoubleSummaryStatistics obterEstatisticas() {
        return alunos.stream()
                .mapToDouble(Aluno::getNota)
                .summaryStatistics();
    }

    public Optional<Aluno> buscarPorNome(String nome) {
        return alunos.stream()
                .filter(a -> a.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }
}